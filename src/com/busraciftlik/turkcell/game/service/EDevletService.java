package com.busraciftlik.turkcell.game.service;

import com.busraciftlik.turkcell.game.entity.Player;

public class EDevletService{

    public boolean verify(Player player) {
        // e-devlet simulation
        System.out.println(player.getFirstName() + " " + player.getLastName() + " person verified");
        return true;
    }
}