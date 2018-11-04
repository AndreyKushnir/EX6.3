package com.company;

import java.util.*;

import static java.lang.System.out;

//        Game Class
//        The application must keep track of games played. A game can be described by its home team, its away
//        team, and each goal that may have been scored.
public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private List<Goal> goals;
//    private List<List<Goal>> teamsGoals;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private int maxGoals;
    private String gameResult;

    void playGame(int maxGoals) {
        this.maxGoals = maxGoals;
        goals = new ArrayList<>(new Random().nextInt(maxGoals + 1));
    }

    public void playGame() {
        goals = new ArrayList<>(new Random().nextInt(7));
    }

    Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamGoals = 0;
        this.awayTeamGoals = 0;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;

        for (Goal goal: goals) {
            if (goal.getTeam().equals(homeTeam)) {
                homeTeamGoals++;
            }
            else awayTeamGoals++;
        }
        updateStatistics();
    }

    private void updateStatistics() {
        homeTeam.addGoalsScored(homeTeamGoals);
        awayTeam.addGoalsScored(awayTeamGoals);


        if (awayTeamGoals < homeTeamGoals) {
            homeTeam.addPoints(2);
            gameResult = homeTeam.getName() + " win ( "
                    + homeTeamGoals + " - " + awayTeamGoals + " )";
        }
        else if (awayTeamGoals > homeTeamGoals) {
            awayTeam.addPoints(2);
            gameResult = awayTeam.getName() + " win ( "
                    + awayTeamGoals + " - " + homeTeamGoals + " )";
        }
        else {
            gameResult = "It's a draw! ( "
                    + awayTeamGoals + " - " + homeTeamGoals + " )";
            homeTeam.addPoints(1);
            awayTeam.addPoints(1);
        }
    }

    public int getMaxGoals() {
        return maxGoals;
    }

    Team getHomeTeam() {
        return homeTeam;
    }

    Team getAwayTeam() {
        return awayTeam;
    }

    void showStatistics() {

        out.println("UEFA game: " + homeTeam.getName() + " - " + awayTeam.getName());

        out.println("\n" + "Goals:");
        for (Goal goal : goals) {
            out.println(goal.toString());
        }

        out.println(gameResult + "\n");
    }

}