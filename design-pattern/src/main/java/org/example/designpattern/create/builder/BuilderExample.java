package org.example.designpattern.create.builder;

/**
 * @author qiqiang
 * @date 2020-10-23 11:44 上午
 */
public class BuilderExample {
    public static void main(String[] args) {
        Hero hero = HeroBuilder.builder().name("韩信")
                .passiveSkill("杀意之枪")
                .skill1("无情冲锋")
                .skill2("背水一战")
                .skill3("国士无双")
                .build();
        System.out.println(hero);
    }
}