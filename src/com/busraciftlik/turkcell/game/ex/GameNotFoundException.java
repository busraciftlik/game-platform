package com.busraciftlik.turkcell.game.ex;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(int id) {
        super("Game with id = " +id +" not found");
    }
    public GameNotFoundException(String name) {
        super("Game with name = "+name +" not found");
    }
}
