package utility;

import java.util.List;

import com.company.Game;
import com.company.Goal;

public class GameUtils {
    public static void addGameGoals(Game game, List<Goal> goals) throws MaxSizeExceeded {
        if (goals.size() <= game.getMaxGoals())
            game.setGoals(goals);
        else throw new MaxSizeExceeded("Too many goals");
    }
}
