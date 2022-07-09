package com.codestates.seb.lol_program.game.db;

import com.codestates.seb.lol_program.db.DbEntity;
import com.codestates.seb.lol_program.game.unit.Unit;

public class RecordEntity extends DbEntity {
    private String userName;
    private Unit unit;
    private int rounds;

    public RecordEntity(String userName, int rounds, Unit unit) {
        super();
        this.userName = userName;
        this.rounds = rounds;
        this.unit = unit;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
}
