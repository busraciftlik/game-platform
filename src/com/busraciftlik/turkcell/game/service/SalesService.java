package com.busraciftlik.turkcell.game.service;


import com.busraciftlik.turkcell.game.entity.Game;
import com.busraciftlik.turkcell.game.entity.Player;

public class SalesService {
    
    private final PlayerService playerService;

    public SalesService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void buyGame(Game game,Player player){
        if(game.getPrice() <= player.getMoney()){
            player.setMoney(player.getMoney() - game.getPrice());
            player.setGame(game);
            playerService.update(player);
        }
    }

}
