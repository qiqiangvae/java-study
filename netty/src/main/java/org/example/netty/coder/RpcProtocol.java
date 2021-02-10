package org.example.netty.coder;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author qiqiang
 */
public class RpcProtocol implements Serializable {
    private static final long serialVersionUID = 42L;
    /**
     * 协议开始标记
     */
    public final int start = RpcProtocolConst.HEAD_START;
    /**
     * header 长度
     */
    private int headerLength;
    /**
     * header
     */
    private RpcProtocolHeader header;
    /**
     * body 长度
     */
    private int bodyLength;
    /**
     * body
     */
    private byte[] body;

    public int getStart() {
        return start;
    }

    public int getHeaderLength() {
        return headerLength;
    }

    public void setHeaderLength(int headerLength) {
        this.headerLength = headerLength;
    }

    public RpcProtocolHeader getHeader() {
        return header;
    }

    public void setHeader(RpcProtocolHeader header) {
        this.header = header;
    }

    public int getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(int bodyLength) {
        this.bodyLength = bodyLength;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "RpcProtocol{" +
                "header=" + header +
                ", body=" + Arrays.toString(body) +
                '}';
    }
}