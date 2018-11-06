package com.company;

import utility.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.*;
import static utility.GameUtils.*;
import static utility.PlayerDatabase.*;

import utility.MaxSizeExceeded;

//        League Class
//        This class contains a single main method. The main method simulates the league by instantiating
//        objects and assigning values.
public class League {

    private List<Game> games;

    private List<Team> teams;

    private final int GAME_INTERVAL = 7;

    private League() {
        games = new ArrayList<>();
        teams = new ArrayList<>();
    }

//    private Player[] getTeam(int numberOfPlayers) throws MaxSizeExceeded {
//        if (numberOfPlayers > 3)
//            throw new MaxSizeExceeded("Too many players selected!");
//
//        else {
//            var playersNames = new PlayerDatabase().;
//            var players = new Player[numberOfPlayers];
//
//            for (Player player: players) {
//                player = new Player(playersNames.
//            }
//        };
//    }

    private void getLeagueAnnouncement(Game gameFirst, Game gameLast) {
        var period = Period.between(gameFirst.getGameDate(), gameLast.getGameDate());
        System.out.println("The league is scheduled to run for " + period.getMonths()
                + " month(s), and " + period.getDays() + " day(s)" + "\n");
    }

    private Team createTeam(String team1name, int numberOfPlayers)  {
//        if (numberOfPlayers > 5)
//            throw new MaxSizeExceeded("Too many players selected!");
        var team = new Team(team1name,
                asList(teamToNames.get(team1name).split(",")).subList(0, numberOfPlayers));
        teams.add(team);
        return team;
    }

//    creating games, ensuring that all teams play each other
//    once as a home team and once as an away team

    private List<Game> createGames(List<Team> teams) {
        int year = Year.now().getValue();
        int day = GAME_INTERVAL;

        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                createGame(teams.get(i), teams.get(j), Year.of(year).atDay((day += GAME_INTERVAL)));
                createGame(teams.get(j), teams.get(i), Year.of(year).atDay(day += GAME_INTERVAL));
            }
        }
        return games;
    }

    private Game createGame(Team team1, Team team2, LocalDate gameDate) {
        var game = new Game(team1, team2, gameDate);
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
                teams.get(teams.size() - 1).getName());
    }

    public static void main(String[] args) {
        var league = new League();

        Team zenit = league.createTeam("Zenit", 5);
        Team fcim = league.createTeam("FCIM", 5);
        Team barcelona = league.createTeam("Barcelona", 5);

        List<Game> games = league.createGames(asList(zenit, fcim, barcelona));

        for (Game game : games) {
            game.playGame(10);
        }

        Game game;
        try {
            game = games.get(0);
            addGameGoals(game, asList(
                    new Goal(game.getHomeTeam(), game.getHomeTeam().getPlayers().get(1), 59.12),
                    new Goal(game.getAwayTeam(), game.getAwayTeam().getPlayers().get(2), 89.12)));

            game = games.get(1);
            addGameGoals(games.get(1), asList(
                    new Goal(game.getAwayTeam(), game.getAwayTeam().getPlayers().get(1), 35.12),
                    new Goal(game.getAwayTeam(), game.getAwayTeam().getPlayers().get(1), 35.12)));

            game = games.get(2);
            addGameGoals(games.get(2), asList(
                    new Goal(game.getHomeTeam(), game.getHomeTeam().getPlayers().get(0), 12.21),
                    new Goal(game.getAwayTeam(), game.getAwayTeam().getPlayers().get(2), 55.12)));

            game = games.get(3);
            addGameGoals(games.get(3), asList(
                    new Goal(game.getHomeTeam(), game.getHomeTeam().getPlayers().get(0), 10.21),
                    new Goal(game.getAwayTeam(), game.getAwayTeam().getPlayers().get(1), 75.12),
                    new Goal(game.getAwayTeam(), game.getAwayTeam().getPlayers().get(2), 85.12)));

        } catch (MaxSizeExceeded e) {
            e.printStackTrace();
        }

        league.getLeagueAnnouncement(games.get(0),games.get(games.size()-1));

        for (Game g : league.games) {
            g.showStatistics();
        }

        league.showStatistics();

    }

}


