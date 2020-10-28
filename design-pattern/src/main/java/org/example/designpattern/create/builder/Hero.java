package org.example.designpattern.create.builder;

/**
 * 需要建造的英雄
 *
 * @author qiqiang
 * @date 2020-10-23 11:35 上午
 */
public class Hero {
    private String name;
    private String skill1;
    private String skill2;
    private String skill3;
    private String passiveSkill;

    public void setName(String name) {
        this.name = name;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }

    public void setSkill3(String skill3) {
        this.skill3 = skill3;
    }

    public void setPassiveSkill(String passiveSkill) {
        this.passiveSkill = passiveSkill;
    }

    @Override
    public String toString() {
        return String.format("%s 技能一：%s,技能一：%s，技能一：%s，被动：%s", name, skill1, skill2, skill3, passiveSkill);
    }
}