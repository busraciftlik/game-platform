package com.busraciftlik.turkcell.game.service;

import com.busraciftlik.turkcell.game.entity.Player;

import java.util.Random;

public class EDevletService{

    public boolean verify(Player player) {
        // e-devlet simulation
        boolean isReal;
        Random random = new Random();
        isReal = random.nextBoolean();

        if(isReal){
            System.out.println(player.getFirstName() + " " + player.getLastName() + " person verified");
        }
        return isReal;
    }
}