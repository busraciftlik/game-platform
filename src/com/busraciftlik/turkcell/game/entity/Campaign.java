package com.busraciftlik.turkcell.game.entity;

public class Campaign extends BaseEntity {

    private String name;
    private double discountPercentage;

    public Campaign(String name, double discountPercentage) {
        this.discountPercentage = discountPercentage;
        this.name = name;
    }

    public Campaign(){}

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Campaign [name=" + name + ", discountPercentage=" + discountPercentage + "]";
    }

    
}
