package org.example.designpattern.create.prototype;

/**
 * 原型模式
 *
 * @author qiqiang
 * @date 2020-10-23 11:27 上午
 */
public class PrototypeExample implements Cloneable {
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeExample example1 = new PrototypeExample();
        example1.name = "prototype";
        PrototypeExample example2 = (PrototypeExample) example1.clone();
        System.out.println(example1 == example2);
        System.out.println(example1.name == example2.name);
    }
}