package com.company;

//        Goal Class
//        The application must keep track of goals scored. A goal can be described by the team who scored it,
//        the player who scored it, and the time it was scored. Represent time as a double.
public class Goal {
    private Team team;
    private Player player;
    private double time;

    public Goal(Team team, Player player, double time) {
        this.team = team;
        this.player = player;
        this.time = time;
    }

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
