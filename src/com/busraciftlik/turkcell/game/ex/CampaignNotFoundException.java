package com.busraciftlik.turkcell.game.ex;

public class CampaignNotFoundException extends RuntimeException {

    public CampaignNotFoundException(int id) {
        super("Contact with id = "+id +" not found");
    }
    public CampaignNotFoundException(String name) {
        super("Contact with id = "+name +" not found");
    }
}
