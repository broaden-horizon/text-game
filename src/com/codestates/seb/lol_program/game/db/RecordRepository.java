package com.codestates.seb.lol_program.game.db;

import com.codestates.seb.lol_program.db.DbRepository;

public class RecordRepository extends DbRepository<RecordEntity> {

    //싱글톤으로 관리하기
    private static RecordRepository recordRepository = null;

    private RecordRepository() {
    }

    public static RecordRepository getInstance() {
        if(recordRepository == null) {
            recordRepository = new RecordRepository();
            return recordRepository;
        }
        return recordRepository;
    }
}
