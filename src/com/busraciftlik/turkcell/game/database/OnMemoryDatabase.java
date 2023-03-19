package com.busraciftlik.turkcell.game.database;

import com.busraciftlik.turkcell.game.entity.Campaign;
import com.busraciftlik.turkcell.game.entity.Game;
import com.busraciftlik.turkcell.game.entity.Player;

import java.util.HashMap;
import java.util.Map;

public final class OnMemoryDatabase {

    public static final Map<Integer,Campaign> CAMPAIGNS = new HashMap<>();
    public static final Map<Integer, Game> GAMES = new HashMap<>();
    public static final Map<Integer, Player> PLAYERS = new HashMap<>();

    private OnMemoryDatabase(){}
}
