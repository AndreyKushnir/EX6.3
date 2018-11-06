package com.company;

import java.time.LocalDate;
import java.util.*;

import static java.lang.System.out;

//        Game Class
//        The application must keep track of games played. A game can be described by its home team, its away
//        team, and each goal that may have been scored.
public class Game {

    private LocalDate gameDate;
    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private int maxGoals;
    private List<Goal> goals;
    private List<GameEvent> gameEvents;
    private String gameResult;

    Game(Team homeTeam, Team awayTeam, LocalDate gameDate) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.gameDate = gameDate;
        this.homeTeamGoals = 0;
        this.awayTeamGoals = 0;
    }

    // почему не сделать отдельный List<Goal> goals,
    // в чем преимущество использования абстрактного класса,
    // если в методе подсчета голов нам нужен конкретно класс Goal?
    void playGame(int maxGoals) {
        this.maxGoals = maxGoals;
        goals = new ArrayList<>(maxGoals);
        gameEvents = new ArrayList<>();

        for (int minute = 1; minute <= 90; minute++) {
            var randomTeam = getRandomTeam();
            var randomPlayer = getRandomPlayer(randomTeam);

            if (minute % 9 == 0) {
                gameEvents.add(new Possession(randomTeam, randomPlayer, minute));
            }

            if ((minute % 30 == 0) && (goals.size() - 1 <= maxGoals)) {
                gameEvents.add(new Goal(randomTeam, randomPlayer, minute));
                goals.add(new Goal(randomTeam, randomPlayer, minute));
            }
        }
        setStatistics(gameEvents);
    }

    private Team getRandomTeam() {
        return (new Random().nextInt(2) == 1) ? homeTeam : awayTeam;
    }

    private Player getRandomPlayer(Team team) {
        return team.getPlayers().get(new Random().nextInt(team.getCountPlayers() + 1));
    }


    LocalDate getGameDate() {
        return gameDate;
    }

    private void setStatistics(List<GameEvent> gameEvents) {

        for (GameEvent event : gameEvents) { // почему нужно проходиться по GameEvent, а не Goal?
            if (event instanceof Goal) {
                if (event.getTeam().equals(homeTeam)) {
                    homeTeamGoals++;
                } else awayTeamGoals++;
            }
        }

        homeTeam.addGoalsScored(homeTeamGoals);
        awayTeam.addGoalsScored(awayTeamGoals);


        if (awayTeamGoals < homeTeamGoals) {
            homeTeam.addPoints(2);
            gameResult = homeTeam.getName() + " win ( "
                    + homeTeamGoals + " - " + awayTeamGoals + " )";
        } else if (awayTeamGoals > homeTeamGoals) {
            awayTeam.addPoints(2);
            gameResult = awayTeam.getName() + " win ( "
                    + awayTeamGoals + " - " + homeTeamGoals + " )";
        } else {
            gameResult = "It's a draw! ( "
                    + awayTeamGoals + " - " + homeTeamGoals + " )";
            homeTeam.addPoints(1);
            awayTeam.addPoints(1);
        }
    }

    public void showStatistics() {

        out.println("UEFA game: " + homeTeam.getName() + " - " + awayTeam.getName());
        out.println(gameDate);
        out.println("\n" + "Events:");
        for (GameEvent gameEvent : gameEvents) {
            out.println(gameEvent.getDescription());
        }

        out.println(gameResult + "\n");
    }

}