package com.company;

//        Goal Class
//        The application must keep track of goals scored. A goal can be described by the team who scored it,
//        the player who scored it, and the time it was scored. Represent time as a double.
public class Goal {
    private Team team;
    private Player player;
    private double time;


    Goal(Team team, Player player, double time) {
        this.team = team;
        this.player = player;
        this.time = time;
    }

    Team getTeam() {
        return team;
    }

    private Player getPlayer() {
        return player;
    }

    private double getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Goal scored after " + getTime() + " mins by "
                + getPlayer().getFullname()
                + " of the " + getTeam().getName();
    }
}
