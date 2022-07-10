package com.codestates.seb.lol_program.game.play;

import com.codestates.seb.lol_program.game.battle.BattleGround;
import com.codestates.seb.lol_program.game.db.RecordEntity;
import com.codestates.seb.lol_program.game.db.RecordRepository;
import com.codestates.seb.lol_program.game.unit.Enemies;
import com.codestates.seb.lol_program.game.unit.Unit;

import java.util.ArrayList;
import java.util.Scanner;

public class Play {
    //변수들
    int round = 1;
    String userName;
    RecordRepository recordRepository = RecordRepository.getInstance();

    public void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("============Game Start==============");

        //유저 이름 받기
        System.out.println("유저 이름을 입력해주세요.");
        userName = scanner.nextLine();

        //내 유닛 생성
        Unit myUnit = new Unit();
        myUnit.startUnit();

        //적 생성
        ArrayList<Unit> enemies = Enemies.getInstance().getUnits();

        //배틀 그라운드 객체 생성
        BattleGround battleGround;

        //최종 보스 이겼는지 파악하는 변수
        boolean finalWin = true;


        //최대 4라운드 돌기
        for(int i = 0; i < enemies.size(); i++) {
            System.out.println("==================================");
            System.out.printf("---------round %d-----------------%n", round);

            battleGround = new BattleGround(myUnit, enemies.get(i));
            while(true) {
                battleGround.askAction();
                battleGround.MeAttack();
                if (battleGround.checkWin()) {
                    round++;
                    //레벨 업
                    myUnit.levelUp();
                    break;
                }
                battleGround.EnemyAttack();
                //게임에서 지면 끝
                if (battleGround.checkWin()) {
                    System.out.println("게임을 종료합니다");
                    //게임 정보 엔티티 생성 및 저장
                    RecordEntity recordEntity = new RecordEntity(userName, round, myUnit);
                    recordRepository.save(recordEntity);
                    i = 100;
                    finalWin = false;
                    break;
                }
            }
        }

        if(finalWin == true) {
            //최종 보스 깨고 나면
            System.out.println("최종 보스를 이겼습니다. 축하합니다!");
            RecordEntity recordEntity = new RecordEntity(userName, round, myUnit);
            recordRepository.save(recordEntity);
        }
    }
}
