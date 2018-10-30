package com.company;

import java.util.ArrayList;
import static java.util.Arrays.*;
import static utility.GameUtils.*;

//        League Class
//        This class contains a single main method. The main method simulates the league by instantiating
//        objects and assigning values.
public class League {

    public Game game;

    // why without arguments?
    public ArrayList<Team> createTeams() {
        var team1 = new Team("Zenit");
        team1.setPlayers(new ArrayList<>(asList( "Kolobkov Aleksandr", "Hromoy Dmitry", "Mozila Ivan")));
        var team2 = new Team("FCIM");
        team2.setPlayers(new ArrayList<>(asList("Falico Serghey", "Balmus Ion", "Perebinos Mihai")));
        return new ArrayList<>(asList(team1,team2));
    }

    public Game createGame(ArrayList<Team> teams) {
        return new Game(teams.get(0),teams.get(1));
    }

    public static void main(String[] args) {
        var league = new League();
        var teams = league.createTeams();
        var uefa = league.createGame(teams);
        uefa.playGame(10);
        addGameGoals(uefa,new ArrayList<>(asList(new Goal(teams.get(0), teams.get(0).getPlayers().get(1), 45.23),
                new Goal(teams.get(1), teams.get(1).getPlayers().get(1), 89.12))));
        uefa.showStatistics();
    }

}


