package com.codestates.seb.lol_program;


import com.codestates.seb.lol_program.game.db.RecordEntity;
import com.codestates.seb.lol_program.game.db.RecordRepository;
import com.codestates.seb.lol_program.game.play.Play;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LOL_Program {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String isAgain = "Y";
    boolean isNotValid = false;
    List<RecordEntity> list;
    //TODO:
    while(isAgain.equals("Y")) {
      Play play = new Play();
      //한 라운드 시작
      play.init();

      //게임 종료 후 기록 보여주기
      System.out.println("=========Game Records============");
      list = RecordRepository.getInstance().findAll();
      for(int i = 0; i < list.size(); i++) {
        System.out.println("---------------------");
        System.out.println("id: " + list.get(i).getIndex());
        System.out.println("닉네임: " + list.get(i).getUserName());
        System.out.println("최종 라운드: " + list.get(i).getRounds());
        System.out.println("---------------------");
      }
      //다시 시작할지 묻기
      do {
        System.out.println("다시 하시겠습니까? (Y / N)");
        isAgain = scanner.nextLine();
        if (!isAgain.equals("Y") && !isAgain.equals("N")) {
          System.out.println("다시 입력해주세요");
          isNotValid = true;
        }
      } while(isNotValid);

    }
  }
}