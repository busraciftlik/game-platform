package com.busraciftlik.turkcell.game.service;

import com.busraciftlik.turkcell.game.entity.Campaign;
import com.busraciftlik.turkcell.game.entity.Game;
import com.busraciftlik.turkcell.game.entity.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class GameApp {
    Scanner scanner = new Scanner(System.in);
    PlayerService playerService = new PlayerService(new EDevletService());
    CampaignService campaignService = new CampaignService();
    GameService gameService = new GameService();
    SalesService salesService = new SalesService();

    public void start() {
        String message = "Please select the option you want to do: \n 1.Player menu \n 2.Campaign menu \n 3.Game menu \n 4.Buy game \n 5.Exit";
        while (true) {
            System.out.println(message);
            int selection = scanner.nextInt();
            if (selection == 1) {
                String ms = "Please select the option you want to do: \n 1.Add player \n 2.Update Player \n 3.Delete Player \n 4.List all records \n 5.Find by id \n 6.Find by name \n 7.Turn to home page";
                System.out.print(ms);
                while (true) {
                    int option = scanner.nextInt();
                    if (option == 1) {
                        addPlayer();
                    }
                    if (option == 2) {
                        updatePlayer();
                    }
                    if (option == 3) {
                        deletePlayer();
                    }
                    if (option == 4) {
                        playerService.getAll();
                    }
                    if (option == 5) {
                        findById();
                    }
                    if (option == 6) {
                        findByName();
                    }
                    if (option == 7) {
                        break;
                    }
                }
            }
            if (selection == 2) {
                String m = "Please select the option you want to do: \n 1.Add campaign \n 2.Update campaign \n 3.Delete campaign \n 4.List all campaigns \n 5.Find by id \n 6.Find by name \n 7.Turn to home page";
                System.out.println(m);
                while (true) {
                    int option = scanner.nextInt();
                    if (option == 1) {
                        addCampaign();
                    }
                    if (option == 2) {
                        updateCampaign();
                    }
                    if (option == 3) {
                        deleteCampaign();
                    }
                    if (option == 4) {
                        campaignService.getAll();
                    }
                    if (option == 5) {
                        findCampaignById();
                    }
                    if (option == 6) {
                        findCampaignByName();
                    }
                    if (option == 7) {
                        break;
                    }
                }
            }
            if (selection == 3) {
                String m = "Please select the option you want to do: \n 1.Add game \n 2.Update game \n 3.Delete game \n 4.List all game \n 5.Find by id \n 6.Find by name \n 7.Turn to home page";
                System.out.print(m);
                while (true) {
                    int option = scanner.nextInt();
                    if (option == 1) {
                        addGame();
                    }
                    if (option == 2) {
                        updateGame();
                    }
                    if (option == 3) {
                        deleteGame();
                    }
                    if (option == 4) {
                        gameService.getAll();
                    }
                    if (option == 5) {
                        findGameById();
                    }
                    if (option == 6) {
                        findGameByName();
                    }
                    if (option == 7) {
                        break;
                    }
                }
            }
            if (selection == 4) {
                buyGame();
            }
            if (selection == 5) {
                break;
            }
        }
    }
    private void addPlayer() {
        System.out.println(" Please enter first name:");
        String firstName = scanner.next();
        System.out.println(" Please enter last name:");
        String lastName = scanner.next();
        System.out.println(" Please enter national identity:");
        String nationalIdentity = scanner.next();
        System.out.println(" Please enter year of birth:");
        String yearOfBirth = scanner.next();
        System.out.println(" Please enter email:");
        String email = scanner.next();
        System.out.println(" Please enter password:");
        String password = scanner.next();
        System.out.print(" Please enter money amount:");
        double money = scanner.nextDouble();
        Player player = new Player(firstName, lastName, nationalIdentity, yearOfBirth, email, password, money, new ArrayList<Game>());
        playerService.add(player);
    }

    private void updatePlayer() {
        System.out.println("Enter the id of the player to be updated:");
        int id = scanner.nextInt();
        Player player = playerService.getById(id);
        playerService.update(player);
    }

    private void deletePlayer() {
        System.out.println("Enter the id of the player to be deleted:");
        int id = scanner.nextInt();
        playerService.delete(id);
    }

    private void findById() {
        System.out.println("Please enter the id:");
        int id = scanner.nextInt();
        playerService.getById(id);
    }

    private void findByName() {
        System.out.println("Please enter the name:");
        String name = scanner.next();
        playerService.getByName(name);
    }

    private void addCampaign() {
        System.out.println("Enter the campaign name:");
        String name = scanner.next();
        System.out.println("Enter the discount percentage");
        double discountPercentage = scanner.nextDouble();
        Campaign campaign = new Campaign(name, discountPercentage);
        campaignService.add(campaign);
    }

    private void deleteCampaign() {
        System.out.println("Enter the id of the campaign to be deleted:");
        int id = scanner.nextInt();
        campaignService.delete(id);
    }

    private void updateCampaign() {
        System.out.print("Enter the id of the campaign to be updated:");
        int id = scanner.nextInt();
        Campaign campaign = campaignService.getById(id);
        campaignService.update(campaign);
    }

    private void findCampaignByName() {
        System.out.print("Please enter the name:");
        String name = scanner.next();
        campaignService.getByName(name);
    }

    private void findCampaignById() {
        System.out.print("Please enter the id:");
        int id = scanner.nextInt();
        campaignService.getById(id);
    }

    private void findGameByName() {
        System.out.println("Please enter the name:");
        String name = scanner.next();
        gameService.getByName(name);
    }

    private void findGameById() {
        System.out.println("Please enter the id:");
        int id = scanner.nextInt();
        gameService.getById(id);
    }

    private void deleteGame() {
        System.out.print("Enter the id of the game to be deleted:");
        int id = scanner.nextInt();
        gameService.delete(id);
    }

    private void updateGame() {
        System.out.print("Enter the id of the game to be updated:");
        int id = scanner.nextInt();
        Game game = gameService.getById(id);
        gameService.update(game);
    }

    private void addGame() {
        System.out.print("Enter the game name:");
        String name = scanner.next();
        System.out.print("Enter the game price:");
        double price = scanner.nextDouble();
        System.out.println("Enter the campaign:");
        System.out.print("Enter the campaign name:");
        String nameCampaign = scanner.next();
        System.out.println("Enter the discount percentage");
        double discountPercentage = scanner.nextDouble();
        Campaign campaign = new Campaign(nameCampaign, discountPercentage);
        Game game = new Game(name, price, campaign);
        gameService.add(game);
    }

    public void buyGame() {
        System.out.println("Welcome!");
        System.out.println("Enter game id:");
        int gameId = scanner.nextInt();
        System.out.println("Enter player id:");
        int playerId = scanner.nextInt();
        salesService.buyGame(gameId, playerId);
    }
}
