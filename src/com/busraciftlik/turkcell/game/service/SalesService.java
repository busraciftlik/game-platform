package com.busraciftlik.turkcell.game.service;


import com.busraciftlik.turkcell.game.entity.Game;
import com.busraciftlik.turkcell.game.entity.Player;

public class SalesService {
    
    private PlayerService playerService;
    private GameService gameService;

    public SalesService() {
    }
    public void buyGame(int gameId, int playerId){
        Player player = playerService.getById(playerId);
        Game game = gameService.getById(gameId);
        if(game.getPrice() <= player.getMoney()){
            player.setMoney(player.getMoney() - game.getPrice());
            player.setGame(game);
            playerService.update(player);
        }
    }
}
