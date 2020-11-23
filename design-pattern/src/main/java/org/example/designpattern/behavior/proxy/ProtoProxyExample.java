package org.example.designpattern.behavior.proxy;

/**
 * @author qiqiang
 * @date 2020-11-06 2:43 下午
 */
public class ProtoProxyExample {
    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son(father);
        son.throwGarbage();
    }
}

interface ThrowGarbageBehavior {
    void throwGarbage();
}

class Father implements ThrowGarbageBehavior {
    @Override
    public void throwGarbage() {
        System.out.println("丢垃圾…………");
    }
}

class Son implements ThrowGarbageBehavior {
    private Father father;

    public Son(Father father) {
        this.father = father;
    }

    @Override
    public void throwGarbage() {
        System.out.println("儿子收到爸爸的命令");
        father.throwGarbage();
    }
}