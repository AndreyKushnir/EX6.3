package com.company;

import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Arrays.*;

//        League Class
//        This class contains a single main method. The main method simulates the league by instantiating
//        objects and assigning values.
public class League {

    public static void main(String[] args) {

        var zenit = new Team("Zenit");
        var fcim = new Team("FCIM");

        fcim.setPlayers(new ArrayList<>(asList("Falico Serghey", "Balmus Ion", "Perebinos Mihai")));
        zenit.setPlayers(new ArrayList<>(asList("Kolobkov Aleksandr", "Hromoy Dmitrii", "Mozila Ivan")));

        ArrayList<Goal> goals = new ArrayList<>();
        goals.add(new Goal(zenit, zenit.getPlayers().get(1), 45.23));
        goals.add(new Goal(fcim, fcim.getPlayers().get(0), 89.12));

        var uefa1 = new Game(zenit, fcim, goals);
        uefa1.showStatistics();

        // --------------- ex7.4---------------------
        System.out.println();
        var player1 = fcim.getPlayer("li");
        if (player1 != null)
            System.out.println(player1.getFullname());

        var player2 = zenit.getPlayer("kob");
        if (player2 != null)
            System.out.println(player2.getFullname());
    }

}


