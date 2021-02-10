package org.example.netty.coder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author qiqiang
 */
public class MessageHandler extends SimpleChannelInboundHandler<RpcProtocol> {
    private final String endpoint;

    public MessageHandler(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcProtocol msg) throws Exception {
        System.out.printf("%s收到消息：----------\n", endpoint);
        System.out.printf("头信息：%s\n", msg.getHeader());
        System.out.printf("内容：%s\n", new String(msg.getBody()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}