package com.busraciftlik.turkcell.game.entity;

import java.time.LocalDate;


public class BaseEntity {

    private static int idCounter = 1;
    private final int id;
    private LocalDate createDate;

    public BaseEntity() {
        this.id = idCounter++;
        this.createDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

}
