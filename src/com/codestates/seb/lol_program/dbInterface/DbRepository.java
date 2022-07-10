package com.codestates.seb.lol_program.dbInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DbRepository<T extends DbEntity> implements DbRepositoryIfs<T>{

    private final List<T> db = new ArrayList<>();
    private int index = 0;


    @Override
    public T save(T entity) {
        index++;
        entity.setIndex(index);
        db.add(entity);
        return entity;
    }

    @Override
    public List<T> findAll() {
        return db;
    }

    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(unit -> unit.getIndex() == index).findFirst();
    }
}
