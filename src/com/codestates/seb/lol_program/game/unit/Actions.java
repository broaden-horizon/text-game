package com.codestates.seb.lol_program.game.unit;

public class Actions {
    private String name;
    private int plusAttackPower;
    private int plusDefencePower;
    private String info;
    //기술 명령어
    private String shortKey;

    public Actions() {

    }

    public Actions(String name, int plusAttackPower, int plusDefencePower, String info, String shortKey) {
        this.name = name;
        this.plusAttackPower = plusAttackPower;
        this.plusDefencePower = plusDefencePower;
        this.info = info;
        this.shortKey = shortKey;
    }

    public void showInfo() {
        if(info == null) {
            System.out.println("스킬을 정의해주세요.");
        } else {
            System.out.println(info);
        }
    }

    public String getShortKey() {
        return shortKey;
    }

    public void setShortKey(String shortKey) {
        this.shortKey = shortKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlusAttackPower() {
        return plusAttackPower;
    }

    public void setPlusAttackPower(int plusAttackPower) {
        this.plusAttackPower = plusAttackPower;
    }

    public int getPlusDefencePower() {
        return plusDefencePower;
    }

    public void setPlusDefencePower(int plusDefencePower) {
        this.plusDefencePower = plusDefencePower;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
