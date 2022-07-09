package com.codestates.seb.lol_program.game.unit;

import javax.swing.*;
import java.util.ArrayList;


public class Skills {

    private static Skills skills = null;
    private static ArrayList<Actions> actionsList = new ArrayList<>();

    private Skills() {
        actionsList.add(fly());
        actionsList.add(underGround());
        actionsList.add(enhencePower());
    }

    public static Skills getInstance() {
        if(skills == null) {
            skills = new Skills();
        }
        return skills;
    }

    public void showInfo() {
        for(int i = 0; i < actionsList.size(); i++) {
            actionsList.get(i).showInfo();
        }
    }

    public Actions fly() {
        Actions fly = new Actions();
        fly.setInfo("(F) 하늘을 나는 능력입니다. 공격력이 5 상승하고, 방어력이 15상승합니다.");
        fly.setName("날기");
        fly.setShortKey("F");
        fly.setPlusAttackPower(5);
        fly.setPlusDefencePower(15);
        return fly;
    }

    public Actions underGround() {
        Actions underGround = new Actions();
        underGround.setInfo("땅으로 숨는 능력입니다. 공격력이 30 하락하고, 방어력이 30 상승합니다.");
        underGround.setName("땅숨기");
        underGround.setShortKey("U");
        underGround.setPlusDefencePower(30);
        underGround.setPlusAttackPower(-30);
        return underGround;
    }

    public Actions enhencePower() {
        Actions enhencePower = new Actions();
        enhencePower.setInfo("주먹을 강화합니다. 공격력이 15 상승하고, 방어력이 0 하락합니다.");
        enhencePower.setName("주먹강화");
        enhencePower.setShortKey("E");
        enhencePower.setPlusAttackPower(15);
        enhencePower.setPlusDefencePower(0);
        return enhencePower;
    }

    public Actions normalAttack() {
        Actions normalAttack = new Actions(
          "기본공격", 5, 0,
          "기본 공격입니다. 공격력이 5 증가합니다.", "A"
        );
        return normalAttack;
    }
    public Actions normalDefence() {
        Actions noramlDefence = new Actions(
                "기본방어", 0, 5,
                "기본 방어입니다. 방어력이 5 증가합니다.", "D"
        );
        return noramlDefence;
    }

}
