package com.codestates.seb.lol_program.dbInterface;

public class DbEntity {

    protected int index;

    public DbEntity() {
        this.index = 0;
    }

    public DbEntity(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
