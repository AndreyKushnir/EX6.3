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


        zenit.addPlayer(new Player("Dzagoev"));
        for (int i=1; i<=2; i++) {
            zenit.addPlayer(new Player("Berezutski " + i));
        }

        fcim.setPlayers(new ArrayList<>(asList("Falico", "Bostan", "Perebinos")));

        ArrayList<Goal> goals = new ArrayList<>();
        goals.add(new Goal(zenit, zenit.getPlayers().get(1), 45.23));
        goals.add(new Goal(fcim, fcim.getPlayers().get(0), 89.12));
        var uefa1 = new Game(zenit,fcim,goals);

        uefa1.showStatistics();

    }

}


