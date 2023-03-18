package com.busraciftlik.turkcell.game.entity;

import java.util.ArrayList;
import java.util.List;

public class Player extends BaseEntity  {

    private String nationalIdentity;
    private String firstName;
    private String lastName;
    private String yearOfBirth;
    private String email;
    private String password;
    private double money;

    private List<Game> games = new ArrayList<>();
    
    public Player(){}

    public Player(String nationalIdentity, String firstName, String lastName, String yearOfBirth, String email,
            String password, double money, List<Game> games) {
        this.nationalIdentity = nationalIdentity;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
        this.password = password;
        this.money = money;
        this.games = games;
    }

    public Player(String nationalIdentity,String firstName, String lastName,String yearOfBirth){
        this.nationalIdentity = nationalIdentity;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void setGame(Game game) {
        this.games.add(game);
    }

    @Override
    public String toString() {
        return "Player [nationalIdentity=" + nationalIdentity + ", firstName=" + firstName + ", lastName=" + lastName
                + ", yearOfBirth=" + yearOfBirth + ", email=" + email + ", password=" + password + ", money=" + money
                + ", games=" + games + "]";
    }

    
}
