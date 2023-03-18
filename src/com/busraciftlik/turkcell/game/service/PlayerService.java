package com.busraciftlik.turkcell.game.service;

import java.util.List;

import com.busraciftlik.turkcell.game.database.PlayerDatabase;
import com.busraciftlik.turkcell.game.entity.Player;
import com.busraciftlik.turkcell.game.service.api.BaseInterface;

public class PlayerService implements BaseInterface<Player> {

    private final EDevletService eDevletService;

    public PlayerService(EDevletService eDevletService) {
        this.eDevletService = eDevletService;
    }

    @Override
    public void add(Player player) {
        if(eDevletService.verify(player)){
            PlayerDatabase.playerList.add(player);
            System.out.println(player.getFirstName() + player.getLastName() + " has been added to the players.");
        }
    }

    @Override
    public void update(Player player) {
        for (Player availablePlayer : PlayerDatabase.playerList) {
            if(availablePlayer.getId() == player.getId()){
                availablePlayer.setFirstName(player.getFirstName());
                availablePlayer.setLastName(player.getLastName());
                availablePlayer.setNationalIdentity(player.getNationalIdentity());
                availablePlayer.setPassword(player.getPassword());
                availablePlayer.setYearOfBirth(player.getYearOfBirth());
                availablePlayer.setEmail(player.getEmail());
                availablePlayer.setGames(player.getGames());
            }
        }
        System.out.println("Update Succesfull.");
    }

    @Override
    public void delete(int id) {
        boolean success = false;
        for (int index = 0; index<PlayerDatabase.playerList.size(); index++){
            if(PlayerDatabase.playerList.get(index).getId() == id){
                PlayerDatabase.playerList.remove(index);
                success = true;
            }
        }
        if(success) {
            System.out.println("Deleted Succesfull.");
        }
        else {
            System.out.println("Records Not Found!!!.");
        }
    }

    @Override
    public List<Player> getAll() {
        return PlayerDatabase.playerList;
    }

    @Override
    public Player getById(int id)  {
        boolean success = false;
        for (int index = 0; index<PlayerDatabase.playerList.size(); index++){
            if(PlayerDatabase.playerList.get(index).getId() == id){
                success = true;
                return PlayerDatabase.playerList.get(index);
            }
        }
        if(!success){
            System.out.println("Records Not Found!!!");
        }
        return new Player();
    }

    @Override
    public Player getByName(String name) {
        boolean success = false;
        for (int index = 0; index<PlayerDatabase.playerList.size(); index++){
            if(PlayerDatabase.playerList.get(index).getFirstName().toLowerCase().equals(name.toLowerCase())){
                success = true;
                return PlayerDatabase.playerList.get(index);
            }
        }
        if(!success){
            System.out.println("Records Not Found!!!");
        }
        return new Player();
    }

    public void addMoneyToWallet(Player player,double money){
        player.setMoney(player.getMoney() + money);
        update(player);
    }

    
}
