package com.company;

import java.util.ArrayList;

//        Team Class
//        Each team has a name. A team also contains a roster of its players.
public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(String fragment) {
        for (Player player: players) {
            if (player.getLastname().contains(fragment)){
                return player;
            }
        }
        return null;
    }

    public void setPlayers(ArrayList<String> fullnames) {
        for (String fullname: fullnames) {
            var names = fullname.split(" ");
            players.add(new Player(names[0],names[1]));
        }
    }
}
