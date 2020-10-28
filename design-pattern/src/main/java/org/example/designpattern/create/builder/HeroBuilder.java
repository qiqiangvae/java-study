package org.example.designpattern.create.builder;

/**
 * @author qiqiang
 * @date 2020-10-23 11:38 上午
 */
public class HeroBuilder {
    private final Hero hero;

    public static HeroBuilder builder() {
        return new HeroBuilder();
    }

    private HeroBuilder() {
        hero = new Hero();
    }

    public HeroBuilder name(String name) {
        hero.setName(name);
        return this;
    }

    public HeroBuilder skill1(String skill1) {
        hero.setSkill1(skill1);
        return this;
    }

    public HeroBuilder skill2(String skill2) {
        hero.setSkill2(skill2);
        return this;
    }

    public HeroBuilder skill3(String skill3) {
        hero.setSkill3(skill3);
        return this;
    }

    public HeroBuilder passiveSkill(String passiveSkill) {
        hero.setPassiveSkill(passiveSkill);
        return this;
    }

    public Hero build() {
        return hero;
    }
}