package org.example.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author qiqiang
 * @date 2020-10-23 5:59 下午
 */
public class BufExample {
    public static void main(String[] args) {
        // 0 -> r=w=c=10
        ByteBuf byteBuf = Unpooled.buffer(10);
        BufUtils.print(byteBuf);
        for (int i = 0; i < 3; i++) {
            byteBuf.writeByte(i);
        }
        BufUtils.print(byteBuf);
        byte[] array = byteBuf.array();
        BufUtils.print(byteBuf);
    }
}