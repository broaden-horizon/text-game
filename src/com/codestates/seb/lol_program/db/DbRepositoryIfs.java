package com.codestates.seb.lol_program.db;

import java.util.List;
import java.util.Optional;

public interface DbRepositoryIfs<T> {
    T save(T entity);
    List<T> findAll();
    Optional<T> findById(int index);
}
