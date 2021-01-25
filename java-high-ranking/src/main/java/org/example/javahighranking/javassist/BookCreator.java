package org.example.javahighranking.javassist;

import javassist.*;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @author qiqiang
 */
public class BookCreator {
    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        create(classPool);
        Class<?> aClass = classPool.get("org.example.javahighranking.javassist.Book").toClass();
        Object book = aClass.getConstructor().newInstance();
        Method description = aClass.getMethod("description");
        System.out.println(description.invoke(book));
    }

    private static void create(ClassPool classPool) throws Exception {
        CtClass stringCtClass = classPool.get(String.class.getName());
        CtClass serializableCtClass = classPool.get(Serializable.class.getName());

        // 1.创建类
        CtClass ctClass = classPool.makeClass("org.example.javahighranking.javassist.Book");
        ctClass.setInterfaces(new CtClass[]{serializableCtClass});
        // 2.创建字段
        // 创建一个bookName字段 private String bookName
        CtField bookName = new CtField(stringCtClass, "bookName", ctClass);
        // 设置访问级别
        bookName.setModifiers(Modifier.PRIVATE);
        // 设置初始值
        ctClass.addField(bookName, CtField.Initializer.constant("倚天屠龙记"));
        // 3.生成 getter、setter
        ctClass.addMethod(CtNewMethod.getter("getBookName", bookName));
        ctClass.addMethod(CtNewMethod.setter("setBookName", bookName));
        // 4.生成普通方法
        CtMethod descriptionMethod = new CtMethod(stringCtClass, "description", new CtClass[]{}, ctClass);
        descriptionMethod.setModifiers(Modifier.PUBLIC);
        descriptionMethod.setBody("{return \"这本书的名字叫做\"+ this.bookName;}");
        ctClass.addMethod(descriptionMethod);
        // 5.生成构造方法
        CtConstructor ctConstructor1 = new CtConstructor(new CtClass[]{}, ctClass);
        // 这里不能少，不然会报错
        ctConstructor1.setBody("{}");
        ctClass.addConstructor(ctConstructor1);
        CtConstructor ctConstructor2 = new CtConstructor(new CtClass[]{stringCtClass}, ctClass);
        ctConstructor2.setBody("{this.bookName = $1;}");
        ctClass.addConstructor(ctConstructor2);

        // 生成的类所在路径
        ctClass.writeFile("java-high-ranking/target/classes/");
    }
}