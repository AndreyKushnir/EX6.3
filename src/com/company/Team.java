package com.company;

import java.util.ArrayList;
import java.util.List;

//        Team Class
//        Each team has a name. A team also contains a roster of its players.
public class Team {
    private String name;
    private List<Player> players;
    private int points;
    private int goalsScored;
    private int countPlayers;
    public final static int MAX_PLAYERS = 5;

    Team(String name, List<String> players) {
        this.name = name;
        points = 0;
        goalsScored = 0;
        this.players = new ArrayList<>();
        countPlayers = players.size() - 1;
        setPlayers(players);
    }

    void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    void addGoalsScored(int goalsScored) {
        this.goalsScored += goalsScored;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    List<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(String fragment) {
        for (Player player : players) {
            if (player.getLastname().contains(fragment)) {
                return player;
            }
        }
        return null;
    }

    private void setPlayers(List<String> fullnames) {
        for (String fullname : fullnames) {
            var names = fullname.split(" ");
            players.add(new Player(names[0], names[1]));
        }

    }

    public int getCountPlayers() {
        return countPlayers;
    }
}
