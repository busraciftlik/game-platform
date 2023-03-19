package com.busraciftlik.turkcell.game.ex;

// TODO: 18.03.2023
public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(int id){
        super("Player with id = " + id + " not found");
    }
    public PlayerNotFoundException(String name){
        super("Player with name = " + name + " not found");
    }
    

    


    

    

    


}
