package org.example.netty.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author qiqiang
 */
public class RpcProtocolToByteEncoder extends MessageToByteEncoder<RpcProtocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, RpcProtocol rpcRequest, ByteBuf byteBuf) throws Exception {
        RpcProtocolHeader header = rpcRequest.getHeader();
        // 将 header 转 byte 数组
        byte[] headerData = HessianUtils.write(header);
        byte[] body = rpcRequest.getBody();
        // 写入开始标志
        byteBuf.writeInt(RpcProtocolConst.HEAD_START);
        // 写入头信息
        byteBuf.writeInt(headerData.length);
        byteBuf.writeBytes(headerData);
        // 写入 body 信息
        if (body == null) {
            byteBuf.writeInt(0);
        } else {
            byteBuf.writeInt(body.length);
            byteBuf.writeBytes(body);
        }
    }
}