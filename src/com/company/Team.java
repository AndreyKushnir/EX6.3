package com.company;

import java.util.ArrayList;
import java.util.List;

//        Team Class
//        Each team has a name. A team also contains a roster of its players.
public class Team {
    private String name;
    private List<Player> players;
//  private List<Game> gamesPlayed;
    private int points;
    private int goalsScored;

    Team(String name) {
        this.name = name;
        players = new ArrayList<>();
        points = 0;
        goalsScored = 0;
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

    void setPlayers(List<String> fullnames) {
        for (String fullname : fullnames) {
            var names = fullname.split(" ");
            players.add(new Player(names[0], names[1]));
        }
    }
}
