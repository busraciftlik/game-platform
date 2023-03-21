package com.busraciftlik.turkcell.game.service;


import com.busraciftlik.turkcell.game.database.OnMemoryDatabase;
import com.busraciftlik.turkcell.game.entity.Game;
import com.busraciftlik.turkcell.game.entity.Player;

public class SalesService {
    
    PlayerService playerService = new PlayerService(new EDevletService());
    GameService gameService = new GameService();

    public SalesService() {
    }
    public void buyGame(int gameId, int playerId){
        Player player = OnMemoryDatabase.PLAYERS.get(playerId);
        Game game = OnMemoryDatabase.GAMES.get(gameId);
        if(game.getPrice() <= player.getMoney()){
            player.setMoney(player.getMoney() - game.getPrice());
            player.setGame(game);
            playerService.update(player);
        }
    }
}
