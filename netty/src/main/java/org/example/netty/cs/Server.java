package org.example.netty.cs;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.StandardCharsets;

/**
 * @author qiqiang
 * @date 2020-10-23 5:46 下午
 */
public class Server {
    public static void main(String[] args) throws InterruptedException {
        // 1. 创建负责接收客户端连接的事件循环组（公司的老板）
        EventLoopGroup boss = new NioEventLoopGroup(1);
        // 2. 创建负责处理客户端发送数据的事件循环组（员工）
        EventLoopGroup worker = new NioEventLoopGroup();
        // 3. 生成服务端启动器
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                // 4. 设置线程队列中等待连接的个数
                .option(ChannelOption.SO_BACKLOG, 128)
                // 5. 保持活动连接状态
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                // 7. 员工跟客户谈事情的地方
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder(StandardCharsets.UTF_8));
                        ch.pipeline().addLast(new StringEncoder(StandardCharsets.UTF_8));
                    }
                });
        // 8. 启动服务器
        ChannelFuture channelFuture = serverBootstrap.bind(8888).sync();
        channelFuture.channel().closeFuture().sync();
    }
}