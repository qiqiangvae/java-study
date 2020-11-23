package org.example.arithmetic.cryptology;

/**
 * 加密过程
 * 1. 选取两个不相等的质数 p 和 q，n=p*q
 * 2. 计算欧拉函数 φ(n)=(p-1)*(q-1)
 * 3. 选取一个整数 e，1<e<φ(n)
 * 4. 计算 e*d mod φ(n)=1，计算出 d 的值
 * 5. 将 n 和 e 封装成公钥，n 和 d 封装成私钥
 *
 * @author qiqiang
 * @date 2020-11-23 3:01 下午
 */
public class RsaExample {
    private long p;
    private long q;
    private long n;
    private long e;

    public static void main(String[] args) {
        RsaExample rsaExample = new RsaExample();
        rsaExample.p = 11;
        rsaExample.q = 17;
        rsaExample.n = 11 * 17;
        rsaExample.e = 94;
    }

    public long encode() {
        return 0;
    }
}