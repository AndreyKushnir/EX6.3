package com.company;

public abstract class GameEvent {

    private Team team;
    private Player player;
    private double time;

    public GameEvent(Team team, Player player, double time) {
        this.team = team;
        this.player = player;
        this.time = time;
    }

    public abstract String getDescription();

    public Team getTeam() {
        return team;
    }

    public Player getPlayer() {
        return player;
    }

    public double getTime() {
        return time;
    }
}
