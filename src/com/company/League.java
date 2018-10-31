package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.*;
import static utility.GameUtils.*;

//        League Class
//        This class contains a single main method. The main method simulates the league by instantiating
//        objects and assigning values.
public class League {

    private List<Game> games;

    private List<Team> teams;

    private League() {
        games = new ArrayList<>();
        teams = new ArrayList<>();
    }

    private Team createTeam(String team1name, List<String> playersNames) {
        var team = new Team(team1name);
        team.setPlayers(playersNames);
        teams.add(team);
        return team;
    }

    private Game createGame(List<Team> teams) {
        var game = new Game(teams.get(0), teams.get(1));
        games.add(game);
        return game;
    }

    public static void main(String[] args) {
        var league = new League();

        var zenit = league.createTeam("Zenit", asList("Kolobkov Aleksandr", "Hromoy Dmitry", "Mozila Ivan"));
        var fcim = league.createTeam("FCIM", asList("Falico Serghey", "Balmus Ion", "Perebinos Mihai"));
        var dinamo = league.createTeam("Dinamo", asList("Ivanov Aleksandr", "Rotaru Dmitry", "Romanov Ivan"));
        var barcelona = league.createTeam("Barcelona", asList("Pepe Romero", "Gonzalez Huan", "Nizshe Frederich"));

        var uefa = league.createGame(asList(dinamo, fcim));
        var uefa2 = league.createGame(asList(zenit, barcelona));

        uefa.playGame(10);
        uefa2.playGame(5);

        try {
            addGameGoals(uefa, asList(new Goal(uefa.getHomeTeam(), uefa.getHomeTeam().getPlayers().get(0), 45.23),
                    new Goal(uefa.getAwayTeam(), uefa.getAwayTeam().getPlayers().get(1), 89.12)));
            addGameGoals(uefa2, asList(new Goal(uefa2.getHomeTeam(), uefa2.getHomeTeam().getPlayers().get(1), 25.23),
                    new Goal(uefa2.getAwayTeam(), uefa2.getAwayTeam().getPlayers().get(1), 19.12)));
        } catch (MaxSizeExceeded e) {
            e.printStackTrace();
        }
        uefa.showStatistics();
        uefa2.showStatistics();

    }

}


