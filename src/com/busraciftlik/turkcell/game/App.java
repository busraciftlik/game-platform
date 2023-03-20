package com.busraciftlik.turkcell.game;

import com.busraciftlik.turkcell.game.service.*;

public class App {
    public static void main(String[] args)  {

        EDevletService eDevletService = new EDevletService();
        PlayerService playerService = new PlayerService(eDevletService);
        SalesService salesService = new SalesService();
        CampaignService campaignService = new CampaignService();
        GameService gameService = new GameService();
        GameApp gameApp = new GameApp();
        gameApp.start();

    }
}
