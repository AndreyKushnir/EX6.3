package com.company;

import java.util.ArrayList;

import static java.lang.System.out;

//        Game Class
//        The application must keep track of games played. A game can be described by its home team, its away
//        team, and each goal that may have been scored.
public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private ArrayList<Goal> goals;

    public Game (Team homeTeam, Team awayTeam, ArrayList<Goal> goals) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.goals = goals;
    }


    public void showStatistics() {
        out.println("UEFA game: " + homeTeam.getName() + " - " + awayTeam.getName());
        out.println(homeTeam.getName() + ":");
        for (Player player: homeTeam.getPlayers()) {
            out.println(player.getFirstname());
        }

        out.println("\n" + awayTeam.getName() + ":");
        for (Player player: awayTeam.getPlayers()) {
            out.println(player.getFirstname());
        }

        out.println("\n" + "Goals:");
        for (Goal goal: goals) {
            out.println("Goal scored after " + goal.getTime() + " mins by "
                    + goal.getPlayer().getFirstname() + " of the " + goal.getTeam().getName());
        }
    }

}