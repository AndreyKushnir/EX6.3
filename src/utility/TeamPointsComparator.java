package utility;

import com.company.Team;

import java.util.Comparator;

public class TeamPointsComparator implements Comparator<Team> {

    @Override
    public int compare(Team t1, Team t2) {
        return Integer.compare(t1.getPoints(), t2.getPoints());
    }
}
