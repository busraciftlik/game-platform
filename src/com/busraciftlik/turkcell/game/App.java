package com.busraciftlik.turkcell.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.busraciftlik.turkcell.game.entity.Campaign;
import com.busraciftlik.turkcell.game.entity.Game;
import com.busraciftlik.turkcell.game.entity.Player;
import com.busraciftlik.turkcell.game.service.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        EDevletService eDevletService = new EDevletService();
        PlayerService playerService = new PlayerService(eDevletService);
        SalesService salesService = new SalesService(playerService);
        CampaignService campaignService = new CampaignService();
        GameService gameService = new GameService();


        boolean main = true;
        String selectNumberMain;
        do {
            System.out.println();
            System.out.println("-----Main-----");
            System.out.println("1-Player Menu");
            System.out.println("2-Campaign Menu");
            System.out.println("3-Game Menu");
            System.out.println("4-Add Campaign To Game");
            System.out.println("5-Buy Game");
            System.out.println("6-Exit");
            System.out.println("---------------");
            System.out.print("Please Select Number:");
            selectNumberMain = input.nextLine();
            switch (selectNumberMain) {
                case "1":
                    playerMenu(input, playerService);
                    Player player;
                    break;
                case "2":
                    campaignMenu(input, campaignService);
                    Campaign campaign;
                    break;
                case "3":
                    gameMenu(input, gameService);
                    Game game;
                    break;
                case "4":
                    List<Campaign> campaignList = campaignService.getAll();
                    for (int i = 0; i < campaignList.size(); i++) {
                        System.out.println("------------------------------");
                        System.out.println("Campaign Id: " + campaignList.get(i).getId());
                        System.out.println("Campaign Name: " + campaignList.get(i).getName());
                        System.out.println("Campaign Discount Percentage: " + campaignList.get(i).getDiscountPercentage());
                        System.out.println("------------------------------");
                    }   
                    System.out.println("Please Enter the Id of the Campaign you want to add.");
                    campaign = campaignService.getById(input.nextInt());
                    if(campaign == null){
                        System.out.print("Records Not Found!!!");
                        break;
                    }
                    else{
                        List<Game> gameList = gameService.getAll();
                        for (int i = 0; i < gameList.size(); i++) {
                            System.out.println("------------------------------");
                            System.out.println("Game Id: " + gameList.get(i).getId());
                            System.out.println("Game Name: " + gameList.get(i).getName());
                            System.out.println("Game Price: " + gameList.get(i).getPrice());
                            System.out.println("------------------------------");
                        }
                        System.out.println("Which Game Would You Like To Add Campaign To?");
                        game = gameService.getById(input.nextInt());
                        if(game != null){
                            game.setCampaign(campaign);
                            gameService.update(game);
                            System.out.println("Game Campaign Added");
                        }
                        else{
                            System.out.print("Records Not Found!!!");
                            break;
                        }
                    }
                    break; 
                case "5":
                    List<Player> playerList = playerService.getAll();
                    for (int i = 0; i < playerList.size(); i++) {
                        System.out.println("------------------------------");
                        System.out.println("Player Id: " + playerList.get(i).getId());
                        System.out.println("Player Name: " + playerList.get(i).getFirstName());
                        System.out.println("Player Surname: " + playerList.get(i).getLastName());
                        System.out.println("Player Year Of Birth:  " + playerList.get(i).getYearOfBirth());
                        System.out.println("Player Total Money: " + playerList.get(i).getMoney());
                        System.out.println("------------------------------");
                    }
                    System.out.println("Please Select Player");
                    player = playerService.getById(input.nextInt());
                    if(player != null){
                        List<Game> gameList = gameService.getAll();
                        for (int i = 0; i < gameList.size(); i++) {
                            System.out.println("------------------------------");
                            System.out.println("Game Id: " + gameList.get(i).getId());
                            System.out.println("Game Name: " + gameList.get(i).getName());
                            System.out.println("Game Price: " + gameList.get(i).getPrice());
                            System.out.println("------------------------------");
                        }
                        System.out.println("Select the game to buy");
                        game = gameService.getById(input.nextInt());
                        if(game != null){
                            if(game.getPrice() <= player.getMoney()){
                                salesService.buyGame(game, player);
                                System.out.println("Purchase Successful.");
                                break;
                            }
                            else{
                                System.out.println("Insufficient Balance");
                                break;
                            }

                        }
                        else {
                            System.out.println("Game records Not Found!!!");
                            break;
                        }

                    }
                    else{
                        System.out.println("Player records Not Found!!!");
                    }
                    break;
        }
        } while (main);

        input.close();
        
        
    }

    private static void gameMenu(Scanner input, GameService gameService) throws Exception {
        boolean gameMenu = true;
        String selectNumberGamenMenu;
        Game game;
        do {
            System.out.println("1-Add Game");
            System.out.println("2-Update Game");
            System.out.println("3-Delete Game");
            System.out.println("4-List all records");
            System.out.println("5-Search By Id");
            System.out.println("6-Search By Name");
            System.out.println("7-Turn Back");
            System.out.println("---------------");
            System.out.print("Please Select Number:");
            selectNumberGamenMenu = input.nextLine();

            switch (selectNumberGamenMenu) {
                case "1":
                    System.out.print("Enter Game Name: ");
                    String gameName = input.nextLine();
                    System.out.print("Enter Game Price: ");
                    Double gamePrice = input.nextDouble();

                    gameService.add(new Game(gameName, gamePrice, null));
                    break;
                case "2":
                    System.out.print("Enter the id of the game you want to update: ");
                    game = gameService.getById(input.nextInt());

                    if(game != null){
                        System.out.print("Enter Game Name: ");
                        game.setName(input.nextLine());
                        System.out.print("Enter Price: ");
                        game.setPrice(input.nextDouble());

                        gameService.update(game);
                        break;
                    }
                case "3":
                    System.out.print("Enter the id of the game you want to delete: ");
                    gameService.delete(input.nextInt());
                    break;
                case "4":
                    List<Game> gameList = gameService.getAll();
                    for (int i = 0; i < gameList.size(); i++) {
                        System.out.println("------------------------------");
                        System.out.println("Game Id: " + gameList.get(i).getId());
                        System.out.println("Game Name: " + gameList.get(i).getName());
                        System.out.println("Game Price: " + gameList.get(i).getPrice());
                        if(gameList.get(i).getCampaign() != null){
                            System.out.println("Game Campaign: " + gameList.get(i).getCampaign().toString());
                        }
                        System.out.println("------------------------------");
                    }
                    break;
                case "5":
                    System.out.print("Enter the id of the game: ");
                    game = gameService.getById(input.nextInt());
                    System.out.println("------------------------------");
                    System.out.println("Game Id: " + game.getId());
                    System.out.println("Game Name: " + game.getName());
                    System.out.println("Game Price: " + game.getPrice());
                    if(game.getCampaign() != null){
                        System.out.println("Game Campaign: " + game.getCampaign().toString());
                    }
                    System.out.println("------------------------------");
                    break;
                case "6":
                    System.out.print("Enter the game of the game: ");
                    game = gameService.getByName(input.nextLine());
                    System.out.println("------------------------------");
                    System.out.println("Game Id: " + game.getId());
                    System.out.println("Game Name: " + game.getName());
                    System.out.println("Game Price: " + game.getPrice());
                    if(game.getCampaign() != null){
                        System.out.println("Game Campaign: " + game.getCampaign().toString());
                    }
                    System.out.println("------------------------------");
                    break;
                case "7":
                gameMenu = false;
            }
        } while (gameMenu);
    }

    private static void campaignMenu(Scanner input, CampaignService campaignService) {
        boolean campaignMenu = true;
        String selectNumberCampaignMenu;
        Campaign campaign;
        do {
            System.out.println("1-Add Campaign");
            System.out.println("2-Update Campaign");
            System.out.println("3-Delete Campaign");
            System.out.println("4-List all records");
            System.out.println("5-Search By Id");
            System.out.println("6-Search By Name");
            System.out.println("7-Turn Back");
            System.out.println("---------------");
            System.out.print("Please Select Number:");
            selectNumberCampaignMenu = input.nextLine();

            switch (selectNumberCampaignMenu) {
                case "1":
                    System.out.print("Enter Campaign Name: ");
                    String campaignName = input.nextLine();
                    System.out.print("Enter Discount Percentage: ");
                    Double discountPercentage = input.nextDouble();

                    campaignService.add(new Campaign(campaignName, discountPercentage));
                    break;
                case "2":
                    System.out.print("Enter the id of the campaign you want to update: ");
                    campaign = campaignService.getById(input.nextInt());

                    if(campaign != null){
                        System.out.print("Enter Campaign Name: ");
                        campaign.setName(input.nextLine());
                        System.out.print("Enter Discount Percentage: ");
                        campaign.setDiscountPercentage(input.nextDouble());

                        campaignService.update(campaign);
                        break;
                    }

                case "3":
                    System.out.print("Enter the id of the campaign you want to delete: ");
                    campaignService.delete(input.nextInt());
                    break;
                case "4":
                    List<Campaign> campaignList = campaignService.getAll();
                    for (int i = 0; i < campaignList.size(); i++) {
                        System.out.println("------------------------------");
                        System.out.println("Campaign Id: " + campaignList.get(i).getId());
                        System.out.println("Campaign Name: " + campaignList.get(i).getName());
                        System.out.println("Campaign Discount Percentage: " + campaignList.get(i).getDiscountPercentage());
                        System.out.println("------------------------------");
                    }
                    break;
                case "5":
                    System.out.print("Enter the id of the campaing: ");
                    campaign = campaignService.getById(input.nextInt());
                    System.out.println("------------------------------");
                    System.out.println("Campaign Id: " + campaign.getId());
                    System.out.println("Campaign Name: " + campaign.getName());
                    System.out.println("Campaign Discount Percentage: " + campaign.getDiscountPercentage());
                    System.out.println("------------------------------");
                    break;
                case "6":
                    System.out.print("Enter the name of the campaing: ");
                    campaign = campaignService.getByName(input.nextLine());
                    System.out.println("------------------------------");
                    System.out.println("Campaign Id: " + campaign.getId());
                    System.out.println("Campaign Name: " + campaign.getName());
                    System.out.println("Campaign Discount Percentage: " + campaign.getDiscountPercentage());
                    System.out.println("------------------------------");
                    break;
                case "7":
                    campaignMenu = false;
            }
        } while (campaignMenu);
    }

    private static void playerMenu(Scanner input, PlayerService playerService) {
        boolean playerMenu = true;
        String selectNumberPlayerMenu;
        Player player;
        do {
            System.out.println("1-Add Player");
            System.out.println("2-Update Player");
            System.out.println("3-Delete Player");
            System.out.println("4-List all records");
            System.out.println("5-Search By Id");
            System.out.println("6-Search By Name");
            System.out.println("7-Turn Back");
            System.out.println("---------------");
            System.out.print("Please Select Number:");
            selectNumberPlayerMenu = input.nextLine();

            switch (selectNumberPlayerMenu) {
                case "1":
                    System.out.print("Enter National Identity: ");
                    String nationalIdentity = input.nextLine();
                    System.out.print("Enter First Name: ");
                    String firstName = input.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = input.nextLine();
                    System.out.print("Enter Year Of Birth: ");
                    String yearOfBirth = input.nextLine();
                    System.out.print("Enter Email: ");
                    String email = input.nextLine();
                    System.out.print("Enter Password: ");
                    String password = input.nextLine();
                    System.out.print("Enter Money Amount: ");
                    Double money = input.nextDouble();

                    playerService.add(new Player(nationalIdentity,firstName,lastName,yearOfBirth,email,password,money,new ArrayList<Game>()));
                    break;
                case "2":
                    System.out.print("Enter the id of the player you want to update: ");
                    player = playerService.getById(input.nextInt());
                    if(player.getFirstName() == null){
                        System.out.println("Records Not Found!!!");
                        break;
                    }
                    else{
                        System.out.print("Enter First Name: ");
                        player.setFirstName(input.nextLine());
                        System.out.print("Enter Last Name: ");
                        player.setLastName(input.nextLine());
                        System.out.print("Enter Year Of Birth: ");
                        player.setYearOfBirth(input.nextLine());
                        System.out.print("Enter Email: ");
                        player.setEmail(input.nextLine());
                        System.out.print("Enter Password: ");
                        player.setPassword(input.nextLine());
                        System.out.print("Enter Money Amount: ");
                        player.setMoney(input.nextDouble());

                        playerService.update(player);
                        break;
                    }

                case "3":
                    System.out.print("Enter the id of the player you want to delete: ");
                    playerService.delete(input.nextInt());
                    break;
                case "4":
                    List<Player> playerList = playerService.getAll();
                    for (int i = 0; i < playerList.size(); i++) {
                        System.out.println("------------------------------");
                        System.out.println("Player Id: " + playerList.get(i).getId());
                        System.out.println("Player Name: " + playerList.get(i).getFirstName());
                        System.out.println("Player Surname: " + playerList.get(i).getLastName());
                        System.out.println("Player Year Of Birth:  " + playerList.get(i).getYearOfBirth());
                        System.out.println("Player Total Money: " + playerList.get(i).getMoney());
                        if(playerList.get(i).getGames().size() > 0){
                            System.out.println("Player's Game " + playerList.get(i).getGames().get(0).toString());

                        }
                        System.out.println("------------------------------");
                    }
                    break;
                case "5":
                    System.out.print("Enter the id of the player: ");
                    player = playerService.getById(input.nextInt());
                    System.out.println("------------------------------");
                    System.out.println("Player Id: " + player.getId());
                    System.out.println("Player Name: " + player.getFirstName());
                    System.out.println("Player Surname: " + player.getLastName());
                    System.out.println("Player Year Of Birth:  " + player.getYearOfBirth());
                    System.out.println("Player Total Money: " + player.getMoney());
                    if(player.getGames().size() > 0){
                        System.out.println("Player's Game " + player.getGames().get(0).toString());
                    }
                    System.out.println("------------------------------");
                    break;
                case "6":
                    System.out.print("Enter the name of the player: ");
                    player = playerService.getByName(input.nextLine());
                    System.out.println("------------------------------");
                    System.out.println("Player Id: " + player.getId());
                    System.out.println("Player Name: " + player.getFirstName());
                    System.out.println("Player Surname: " + player.getLastName());
                    System.out.println("Player Year Of Birth:  " + player.getYearOfBirth());
                    System.out.println("Player Total Money: " + player.getMoney());
                    if(player.getGames().size() > 0){
                        System.out.println("Player's Game " + player.getGames().get(0).toString());
                    }
                    System.out.println("------------------------------");
                    break;
                case "7":
                    playerMenu = false;
            }
        } while (playerMenu);
    }
}
