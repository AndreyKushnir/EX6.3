package com.company;

import utility.MaxSizeExceeded;
import utility.TeamGoalsComparator;
import utility.TeamPointsComparator;

import java.util.ArrayList;
import java.util.Comparator;
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

    private void showStatistics() {
        teams.sort(new TeamPointsComparator().thenComparing(new TeamGoalsComparator()));

        for (Team team : teams) {
            System.out.println(team.getName() + " : "
                    + team.getPoints() + " : "
                    + team.getGoalsScored());
        }

        System.out.println("This year champions are: " +
                teams.get(teams.size()-1).getName());
    }

    public static void main(String[] args) {
        var league = new League();

        var zenit = league.createTeam("Zenit",
                asList("Kolobkov Aleksandr", "Hromoy Dmitry", "Mozila Ivan"));
        var fcim = league.createTeam("FCIM",
                asList("Falico Serghey", "Balmus Ion", "Perebinos Mihai"));

        var uefa1 = league.createGame(asList(zenit, fcim));
        var uefa2 = league.createGame(asList(fcim, zenit));
        var uefa3 = league.createGame(asList(zenit, fcim));

        uefa1.playGame(10);
        uefa2.playGame(5);
        uefa3.playGame(10);


        try {
            addGameGoals(uefa1, asList(
                    new Goal(uefa1.getHomeTeam(), uefa1.getHomeTeam().getPlayers().get(0), 45.23),
                    new Goal(uefa1.getAwayTeam(), uefa1.getAwayTeam().getPlayers().get(1), 59.12),
                    new Goal(uefa1.getAwayTeam(), uefa1.getAwayTeam().getPlayers().get(2), 89.12)));

            addGameGoals(uefa2, asList(
                    new Goal(uefa2.getAwayTeam(), uefa2.getAwayTeam().getPlayers().get(1), 35.12),
                    new Goal(uefa2.getAwayTeam(), uefa2.getAwayTeam().getPlayers().get(1), 35.12)));

            addGameGoals(uefa3, asList(
                    new Goal(uefa3.getHomeTeam(), uefa3.getHomeTeam().getPlayers().get(0), 12.21),
                    new Goal(uefa3.getAwayTeam(), uefa3.getAwayTeam().getPlayers().get(2), 55.12)));
        } catch (MaxSizeExceeded e) {
            e.printStackTrace();
        }


        uefa1.showStatistics();
        uefa2.showStatistics();
        uefa3.showStatistics();

        league.showStatistics();
    }

}


