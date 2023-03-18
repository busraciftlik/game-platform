package com.busraciftlik.turkcell.game.service.api;

import java.util.List;

public interface BaseInterface<T> {
    
    void add(T t);

    void update(T t);

    void delete(int i);

    List<T> getAll();

    T getById(int id) throws Exception;

    T getByName(String name);

}
