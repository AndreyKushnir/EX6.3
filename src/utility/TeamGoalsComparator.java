package utility;

import com.company.Team;

import java.util.Comparator;

public class TeamGoalsComparator implements Comparator<Team> {
    @Override
    public int compare(Team t1, Team t2) {
        return Integer.compare(t1.getGoalsScored(), t2.getGoalsScored());
    }
}
