package com.company;

public class Possession extends GameEvent {

    public Possession(Team team, Player player, double time) {
        super(team, player, time);
    }

    @Override
    public String getDescription() {
        return "Possession on " + getTime() + " min by "
                + getPlayer().getFullname()
                + " of the " + getTeam().getName();
    }
}
