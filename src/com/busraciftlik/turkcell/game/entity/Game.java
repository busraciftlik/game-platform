package com.busraciftlik.turkcell.game.entity;

public class Game extends BaseEntity {

    private String name;
    private double price;

    private Campaign campaign;

    public Game( String name, double price,Campaign campaign) {
        this.name = name;
        this.price = price;
        this.campaign = campaign;
    }

    public Game(){}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    @Override
    public String toString() {
        return "Game [name=" + name + ", price=" + price + ", campaign=" + campaign + "]";
    }

    

}

