package com.codestates.seb.lol_program.game.unit;

import java.util.ArrayList;

//기술을 만들어 모아두는 클래스
public class Skills {

    private static Skills skills = null;
    private static ArrayList<Actions> actionsList = new ArrayList<>();

    public static ArrayList<Actions> getActionsList() {
        return actionsList;
    }

    //생성자 초기화 될 때 세 개의 스킬을 스태틱 변수에 저장.
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

    public static Actions fly() {
        Actions fly = new Actions();
        fly.setInfo("날기: 공격력이 5 상승하고, 방어력이 15상승합니다.");
        fly.setName("날기");
        fly.setShortKey("F");
        fly.setPlusAttackPower(5);
        fly.setPlusDefencePower(15);
        return fly;
    }

    public static Actions underGround() {
        Actions underGround = new Actions();
        underGround.setInfo("땅숨기: 공격력이 30 하락하고, 방어력이 30 상승합니다.");
        underGround.setName("땅숨기");
        underGround.setShortKey("U");
        underGround.setPlusDefencePower(30);
        underGround.setPlusAttackPower(-30);
        return underGround;
    }

    public static Actions enhencePower() {
        Actions enhencePower = new Actions();
        enhencePower.setInfo("주먹강화: 공격력이 15 상승하고, 방어력이 0 하락합니다.");
        enhencePower.setName("주먹강화");
        enhencePower.setShortKey("E");
        enhencePower.setPlusAttackPower(15);
        enhencePower.setPlusDefencePower(0);
        return enhencePower;
    }

    public static Actions normalAttack() {
        Actions normalAttack = new Actions(
          "기본공격", 5, 0,
          "기본 공격입니다. 공격력이 5 증가합니다.", "A"
        );
        return normalAttack;
    }
    public static Actions normalDefence() {
        Actions noramlDefence = new Actions(
                "기본방어", 0, 5,
                "기본 방어입니다. 방어력이 5 증가합니다.", "D"
        );
        return noramlDefence;
    }

    //기술 클래스
    public static class Actions {
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
            System.out.print(info);
            System.out.println(" Press " + shortKey);

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
}
