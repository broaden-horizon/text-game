package com.codestates.seb.lol_program.game.battle;

import com.codestates.seb.lol_program.game.unit.Actions;
import com.codestates.seb.lol_program.game.unit.Unit;

import java.util.Optional;
import java.util.Scanner;

public class BattleGround {
    private boolean isGameOver = false; //이걸 체크해서 트루이면 게임 종료 시퀀스 시작
    private Unit unitMe;
    private Unit unitEnemy;

    public BattleGround(Unit unitMe, Unit unitEnemy) {
        this.unitMe = unitMe;
        this.unitEnemy = unitEnemy;
    }

    //액션 물어봐서 수행하기
  public void askAction() {
        Scanner scanner = new Scanner(System.in);
        // 유닛 정보 출력
        System.out.println("=================================");
        System.out.println("나의 유닛");
        unitMe.showInfo();
        System.out.println("---------------------------------");
        System.out.println("적의 유닛");
        unitEnemy.showInfo();
        System.out.println("=================================");


        System.out.println("어떤 액션을 취하시겠습니까?");
        String key = scanner.nextLine();
        Optional<Actions> optionalAction = unitMe
                .getActions()
                .stream()
                .filter(keys -> keys.getShortKey().equals(key))
                .findFirst();
        Actions realAction;
        if(optionalAction.isEmpty()) {
            System.out.println("다시 입력해주세요");
            askAction();
        } else {
            realAction = optionalAction.get();
            unitMe.setTempAttackPower(unitMe.getAttackPower() + realAction.getPlusAttackPower());
            unitMe.setTempDefencePower(unitMe.getDefencePower() + realAction.getPlusDefencePower());
            System.out.println("다음 액션을 수행합니다: " + realAction.getName());
            System.out.println("최종 공격력: " + Integer.toString(unitMe.getTempAttackPower()));
            System.out.println("최종 방어력: " + Integer.toString(unitMe.getTempDefencePower()));
            System.out.println();
        }

    }

    public void MeAttack() {
        attack(unitMe, unitEnemy);
    }

    public void EnemyAttack() {
        attack(unitEnemy, unitMe);

    }

    public void attack(Unit attackUnit, Unit defenceUnit) {
        //공격자의 공격력과 방어자의 방어력의 합에서 공격자의 공격력이 차지하는 비율만큼의 값을 방어자의 체력에서 감소
        double attackRatio = ((double) attackUnit.getTempAttackPower() / (double) (attackUnit.getTempAttackPower() + defenceUnit.getTempDefencePower()));
        int damage = (int) (attackUnit.getTempAttackPower() * attackRatio);
        //방어자의 체력 감소
        defenceUnit.setHp(defenceUnit.getHp() - damage <= 0 ? 0 : defenceUnit.getHp() - damage);

        System.out.printf("%s이(가) 공격합니다. %n", attackUnit.getUnitName());
        System.out.printf("공격! %d %n", unitMe.getTempAttackPower());
        System.out.printf("%s이(가) 입은 데미지 %d %n", defenceUnit.getUnitName(), damage);
        System.out.printf("%s의 남은 체력: %d", defenceUnit.getUnitName(), unitEnemy.getHp());
        System.out.println();
        System.out.println();


        //죽은 경우
        if(defenceUnit.getHp() - damage <= 0) {
            System.out.printf("%s가 이겼습니다. 게임을 종료합니다.", attackUnit.getUnitName());
            System.out.println();
            System.out.println();
            isGameOver = true;
        }
    }

    public boolean checkWin() {
        if(isGameOver == true) {
            return true;
        }
        return false;
    }



}
