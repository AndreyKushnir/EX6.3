package com.company;

//        Goal Class
//        The application must keep track of goals scored. A goal can be described by the team who scored it,
//        the player who scored it, and the time it was scored. Represent time as a double.
public class Goal extends GameEvent {

    Goal(Team team, Player player, double time) {
        super(team, player, time);
    }

    @Override
    public String getDescription() {
        return "Goal scored after " + getTime() + " mins by "
                + getPlayer().getFullname()
                + " of the " + getTeam().getName();
    }

}
