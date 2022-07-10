package com.codestates.seb.lol_program.game.unit;

import com.sun.security.jgss.GSSUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Unit {
    private int level;
    private String unitName;
    private int attackPower;
    private int defencePower;
    private int hp;

    //습득한 기술을 모아두는 변수
    private ArrayList<Skills.Actions> actions = new ArrayList<>();
    private int tempAttackPower = 0;
    private int tempDefencePower = 0;
    public String getUnitName() {
        return unitName;
    }
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

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

    public Unit(String unitName, int attackPower, int defencePower, int hp, int level) {
        this.unitName = unitName;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.hp = hp;
        this.level = level;
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
        System.out.print("유닛 이름 : " + unitName + ", ");
        System.out.println("레벨 : " + level);
        System.out.print("공격력: " + attackPower + ", ");
        System.out.print("방어력: " + defencePower + ", ");
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

    public ArrayList<Skills.Actions> getActions() {
        return actions;
    }

    public void levelUp() {
        //variables
        Scanner scanner = new Scanner(System.in);
          //skillChosen set
        ArrayList<Skills.Actions> skills = Skills.getActionsList();
        String skillChosen;

        //기본 업그레이드
        this.level++;
        this.attackPower += 10;
        this.defencePower += 10;
        this.hp += 10;
        System.out.println("level up!");
        System.out.println("공격력/방어력/체력이 10증가했습니다.");
        //습득할 기술이 남았는지 확인
        if(skills.size() + 2 == actions.size()) {
            System.out.println(skills.size());
            System.out.println(actions.size());
            System.out.println("이미 모든 기술을 습득했습니다.");
            return;
        }
        //기술 습득
        System.out.println("새로운 기술을 습득할 수 있습니다.");
        while(true) {
            //가지고 있지 않은 기술의 단축키 저장 변수
            ArrayList<String> skillsDontHave = new ArrayList<>();
            System.out.println("어떤 기술을 습득하시겠습니까?");
            //이미 가지고 있는 스킬 이외의 스킬 출력
            boolean isHave = false;
            for(Skills.Actions skill : skills) {
                for(Skills.Actions action : actions) {
                    if(action == skill) {
                      isHave = true;
                      break;
                    }
                }
                if(isHave == false) {
                    skill.showInfo();
                    skillsDontHave.add(skill.getShortKey());
                }
                isHave = false;
            }
            skillChosen = scanner.nextLine();
            if(skillsDontHave.contains(skillChosen)) {
                break;
            }
            System.out.println("잘못 입력하셨습니다.");
        }
        switch(skillChosen) {
            case "F":
                actions.add(Skills.getActionsList().stream().filter(a -> a.getShortKey().equals("F")).findFirst().get());
                System.out.println("날기 기술이 추가되었습니다.");
                break;
            case "U":
                actions.add(Skills.getActionsList().stream().filter(a -> a.getShortKey().equals("U")).findFirst().get());
                System.out.println("땅숨기 기술이 추가되었습니다.");
                break;
            case "E":
                actions.add(Skills.getActionsList().stream().filter(a -> a.getShortKey().equals("E")).findFirst().get());
                System.out.println("주먹강화 기술이 추가되었습니다.");
                break;
        }
        showInfo();
    }

}
