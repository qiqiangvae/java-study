package org.example.netty.coder;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qiqiang
 */
public class ClientExample {
    public static void main(String[] args) {
        Bootstrap serverBootstrap = new Bootstrap();
        EventLoopGroup group = new NioEventLoopGroup();
        serverBootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ByteToRpcProtocolDecoder());
                        ch.pipeline().addLast(new RpcProtocolToByteEncoder());
                        ch.pipeline().addLast(new MessageHandler("客户端"));
                    }
                });
        try {
            ChannelFuture channelFuture = serverBootstrap.connect("localhost", 9999).sync();
            Channel channel = channelFuture.channel();
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            for (int i = 0; i < 100; i++) {
                int finalI = i;
                executorService.execute(() -> {
                    RpcProtocol rpcProtocol = new RpcProtocol();
                    rpcProtocol.setBody(String.format("hello server %d", finalI).getBytes());
                    RpcProtocolHeader header = new RpcProtocolHeader();
                    header.setId(UUID.randomUUID().toString());
                    header.setVersion("V1.0");
                    rpcProtocol.setHeader(header);
                    channel.writeAndFlush(rpcProtocol);
                });
            }
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}