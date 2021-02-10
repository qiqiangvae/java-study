package org.example.netty.coder;

import java.io.Serializable;

/**
 * 协议头
 *
 * @author qiqiang
 */
public class RpcProtocolHeader implements Serializable {
    private static final long serialVersionUID = 42L;
    /**
     * 请求id
     */
    private String id;
    /**
     * 版本号
     */
    private String version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "RpcProtocolHeader{" +
                "id='" + id + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}