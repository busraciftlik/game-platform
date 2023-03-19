package com.busraciftlik.turkcell.game.ex;

public class CampaignNotFoundException extends RuntimeException {

    public CampaignNotFoundException(int id) {
        super("Campaign with id = "+id +" not found");
    }
    public CampaignNotFoundException(String name) {
        super("Campaign with name = "+name +" not found");
    }
}
