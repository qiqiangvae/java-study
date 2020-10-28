package org.example.netty.buf;

import io.netty.buffer.ByteBuf;

import java.util.Arrays;

/**
 * @author qiqiang
 * @date 2020-10-23 6:08 下午
 */
public class BufUtils {
    public static void print(ByteBuf byteBuf) {
        byte[] dst = new byte[byteBuf.readableBytes()];
        byteBuf.getBytes(byteBuf.readerIndex(), dst);
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex();
        int capacity = byteBuf.capacity();
        System.out.printf("r[%d],w[%d],c[%d],data:%s\n", readerIndex, writerIndex, capacity, Arrays.toString(dst));
    }
}