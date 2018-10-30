package com.company;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.out;

//        Game Class
//        The application must keep track of games played. A game can be described by its home team, its away
//        team, and each goal that may have been scored.
public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private ArrayList<Goal> goals;

    public void playGame(int maxGoals) {
        goals = new ArrayList<>(new Random().nextInt(maxGoals+1));
    }

    public void playGame() {
        goals = new ArrayList<>(new Random().nextInt(7));
    }

    public Game (Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void setGoals(ArrayList<Goal> goals) {
        this.goals = goals;
    }

    public void showStatistics() {
        out.println("UEFA game: " + homeTeam.getName() + " - " + awayTeam.getName());

        out.println("\n" + "Goals:");
        for (Goal goal: goals) {
            out.println("Goal scored after " + goal.getTime() + " mins by "
                    + goal.getPlayer().getFullname()
                    + " of the " + goal.getTeam().getName());
        }
    }

}