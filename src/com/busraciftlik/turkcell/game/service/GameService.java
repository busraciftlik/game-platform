package com.busraciftlik.turkcell.game.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.busraciftlik.turkcell.game.database.OnMemoryDatabase;
import com.busraciftlik.turkcell.game.entity.Campaign;
import com.busraciftlik.turkcell.game.entity.Game;
import com.busraciftlik.turkcell.game.ex.GameNotFoundException;
import com.busraciftlik.turkcell.game.service.api.BaseInterface;

public class GameService implements BaseInterface<Game> {

    @Override
    public void add(Game game) {
        OnMemoryDatabase.GAMES.put(game.getId(),game);
    }

    @Override
    public void update(Game game) {
        if (OnMemoryDatabase.GAMES.containsKey(game.getId())) {
            OnMemoryDatabase.GAMES.put(game.getId(), game);
        } else {
            throw new GameNotFoundException(game.getId());
        }
    }

    @Override
    public void delete(int id)  {
        if(OnMemoryDatabase.GAMES.containsKey(id)){
        OnMemoryDatabase.GAMES.remove(id);
        }
        throw new GameNotFoundException(id);
    }

    @Override
    public List<Game> getAll() {
       return new ArrayList<Game>(OnMemoryDatabase.GAMES.values());
    }

    @Override
    public Game getById(int id) throws Exception {
        return OnMemoryDatabase.GAMES.get(id);
    }

    @Override
    public Game getByName(String name) {
        Collection<Game> games = OnMemoryDatabase.GAMES.values();
        for (Game game : games) {
            if (game.getName().equalsIgnoreCase(name)) {
                return game;
            }
        }
        throw new GameNotFoundException(name);
    }

    public void changedCampaign(Game game, Campaign campaign){
        game.setCampaign(campaign);
        update(calculatePriceForCampaign(game));
    }

    public Game calculatePriceForCampaign(Game game){
        if(game.getCampaign() != null) {
            game.setPrice(game.getPrice() -  (game.getPrice() * game.getCampaign().getDiscountPercentage()) / 100);
        }
        return game;
    }
}
