package org.example.netty.coder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author qiqiang
 */
public class ServerExample {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ByteToRpcProtocolDecoder());
                        ch.pipeline().addLast(new RpcProtocolToByteEncoder());
                        ch.pipeline().addLast(new MessageHandler("服务端"));
                    }
                });
        try {
            ChannelFuture channelFuture = serverBootstrap.bind(9999).sync();
            System.out.println("服务端启动，端口9999");
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}