package com.company;

import utility.*;

import java.time.Period;
import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.*;
import static utility.PlayerDatabase.*;

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

//    private Player[] getTeam(int numberOfPlayers) throws PlayerDatabaseException {
//        if (numberOfPlayers > 3)
//            throw new PlayerDatabaseException("Too many players selected!");
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

    private Team createTeam(String team1name, int numberOfPlayers) throws PlayerDatabaseException {
        if (numberOfPlayers > 5)
            throw new PlayerDatabaseException("Too many players selected! (" + numberOfPlayers +"). " +
                    "The max count is " + Team.MAX_PLAYERS);
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
                games.add(new Game(teams.get(i), teams.get(j), Year.of(year).atDay((day += GAME_INTERVAL))));
                games.add(new Game(teams.get(j), teams.get(i), Year.of(year).atDay(day += GAME_INTERVAL)));
            }
        }
        return games;
    }


    private void showBestTeams() {
        teams.sort(Comparator.comparing(Team::getPoints).
                thenComparing(Team::getGoalsScored).
                thenComparing(Team::getName));

//      teams.sort(new TeamGoalsComparator().thenComparing(new TeamPointsComparator()));

        List<Team> champions = new ArrayList<>();
        champions.add(teams.get(teams.size()-1));

        for (Team team : teams) {
            System.out.println(team.getName() + " : "
                    + team.getPoints() + " : "
                    + team.getGoalsScored());
        }

        for (int i=teams.size()-1; i>0; i--) {
            if (teams.get(i-1) == teams.get(i)){
                champions.add(teams.get(i-1));
            }
        }

        System.out.println("This year champions are: ");
        for (Team champion : champions)
            System.out.println(champion.getName());
    }

    public static void main(String[] args) {
        var league = new League();

        try {
            Team zenit = league.createTeam("Zenit", 10);
            Team fcim = league.createTeam("FCIM", 5);
            Team barcelona = league.createTeam("Barcelona", 5);

            List<Game> games = league.createGames(asList(zenit, fcim, barcelona));

            for (Game game : games) {
                game.playGame(10);
            }

            league.getLeagueAnnouncement(games.get(0),games.get(games.size()-1));

            for (Game g : league.games) {
                g.showStatistics();
            }

            league.showBestTeams();
        } catch (PlayerDatabaseException ex) {
            ex.printStackTrace();
        }

    }

}


