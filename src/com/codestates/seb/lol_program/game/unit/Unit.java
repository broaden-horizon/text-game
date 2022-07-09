package com.codestates.seb.lol_program.game.unit;

import java.util.ArrayList;
import java.util.Scanner;

public class Unit {
    private int level;
    private String unitName;
    private int attackPower;
    private int defencePower;
    private int hp;

    public String getUnitName() {
        return unitName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    private ArrayList<Actions> actions = new ArrayList<>();
    private int tempAttackPower = 0;
    private int tempDefencePower = 0;

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefencePower() {
        return defencePower;
    }

    public int getTempAttackPower() {
        return tempAttackPower;
    }

    public void setTempAttackPower(int tempAttackPower) {
        this.tempAttackPower = tempAttackPower;
    }

    public int getTempDefencePower() {
        return tempDefencePower;
    }

    public void setTempDefencePower(int tempDefencePower) {
        this.tempDefencePower = tempDefencePower;
    }

    public Unit() {
    }

    public Unit(String unitName, int attackPower, int defencePower, int hp) {
        this.unitName = unitName;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.hp = hp;
    }

    //나의 유닛 초기 세팅
    public void startUnit() {
        hp = 30;
        level = 1;
        actions.add(Skills.getInstance().normalAttack());
        actions.add(Skills.getInstance().normalDefence());

        String type;
        Scanner scanner = new Scanner(System.in);
        System.out.println("유닛의 이름을 지어주세요");
        this.unitName = scanner.nextLine();

        while(true) {
            System.out.println("어떤 타입의 유닛을 만드시겠습니까? (A / B)");
            System.out.println("공격형(A) ( 공격력 10 방어력 5)");
            System.out.println("방어형(B) ( 공격력 5 방어력 10)");
            type = scanner.nextLine();
            if (!type.equals("A") && !type.equals("B")) {
                System.out.println("다시 입력해주세요.");
            } else {
                break;
            }
        }
        if(type.equals("A")) {
            attackPower = 10;
            defencePower = 5;
        } else {
            attackPower = 5;
            defencePower = 10;
        }
        System.out.println("유닛이 생성되었습니다.");
        showInfo();
    }



    public void showInfo() {
        System.out.println("유닛 이름 : " + unitName);
        System.out.println("레벨 : " + level);
        System.out.println("공격력: " + attackPower);
        System.out.println("방어력: " + defencePower);
        System.out.println("체력: " + hp);
        if(actions == null) {
            System.out.println("아직 기술이 없습니다.");
        } else {
            System.out.println("스킬 셋:");
            for (int i = 0; i < actions.size(); i++) {
                System.out.print(actions.get(i).getName());
                System.out.print("(단축키: " + actions.get(i).getShortKey()+")");
                System.out.print(", 공격력: +" + actions.get(i).getPlusAttackPower());
                System.out.print(", 방어력: +" + actions.get(i).getPlusDefencePower());
                System.out.println();
            }
        }
    }

    public ArrayList<Actions> getActions() {
        return actions;
    }

    public void levelUp() {
        this.level++;
        this.attackPower += 10;
        this.defencePower += 10;
        this.hp += 10;
        System.out.println("level up!");
        System.out.println("공격력/방어력/체력이 10증가했습니다.");
        String skill;;
        Scanner scanner = new Scanner(System.in);
        System.out.println("새로운 기술을 습득할 수 있습니다.");
        Skills.getInstance().showInfo();

        while(true) {
            System.out.println("어떤 기술을 습득하시겠습니까?");
            System.out.println("날기(F), 땅숨기(U), 주먹강화(E)");
            skill = scanner.nextLine();
            if(skill.equals("F") || skill.equals("U") || skill.equals("E")) {
                break;
            }
            System.out.println("잘못 입력하셨습니다.");
        }
        switch(skill) {
            case "F":
                actions.add(Skills.getInstance().fly());
                System.out.println("날기 기술이 추가되었습니다.");
                break;
            case "U":
                actions.add(Skills.getInstance().underGround());
                System.out.println("땅숨기 기술이 추가되었습니다.");
                break;
            case "E":
                actions.add(Skills.getInstance().enhencePower());
                System.out.println("주먹강화 기술이 추가되었습니다.");
                break;
        }
        showInfo();
    }

}
