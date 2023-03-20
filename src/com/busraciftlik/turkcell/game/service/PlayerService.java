package com.busraciftlik.turkcell.game.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.busraciftlik.turkcell.game.database.OnMemoryDatabase;
import com.busraciftlik.turkcell.game.entity.Player;
import com.busraciftlik.turkcell.game.ex.PlayerNotFoundException;
import com.busraciftlik.turkcell.game.service.api.BaseInterface;

public class PlayerService implements BaseInterface<Player> {

    private final EDevletService eDevletService;

    public PlayerService(EDevletService eDevletService) {
        this.eDevletService = eDevletService;
    }

    @Override
    public void add(Player player) {
        if(eDevletService.verify(player)){
            OnMemoryDatabase.PLAYERS.put(player.getId(),player);
            System.out.println(player.getFirstName() +" "+ player.getLastName() + " has been added to the players.");
        }
    }
    @Override
    public void update(Player player) {
        if (OnMemoryDatabase.PLAYERS.containsKey(player.getId())) {
            OnMemoryDatabase.PLAYERS.put(player.getId(), player);
        } else {
            throw new PlayerNotFoundException(player.getId());
        }
    }

    @Override
    public void delete(int id) {
        if (OnMemoryDatabase.PLAYERS.containsKey(id)) {
            OnMemoryDatabase.PLAYERS.remove(id);
        }
        throw new PlayerNotFoundException(id);
    }
    @Override
    public List<Player> getAll() {
        return new ArrayList<Player>(OnMemoryDatabase.PLAYERS.values());
    }

    @Override
    public Player getById(int id)  {
        return OnMemoryDatabase.PLAYERS.get(id);
    }
    @Override
    public Player getByName(String name) {
        Collection<Player> players = OnMemoryDatabase.PLAYERS.values();
        for (Player player : players) {
            if (player.getFirstName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        throw new PlayerNotFoundException(name);
    }

    public void addMoneyToWallet(Player player,double money){
        player.setMoney(player.getMoney() + money);
        update(player);
    }
}
