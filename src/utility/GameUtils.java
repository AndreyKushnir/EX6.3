package utility;

import java.util.ArrayList;
import com.company.Game;
import com.company.Goal;

public class GameUtils {
    public static void addGameGoals(Game game, ArrayList<Goal> goals) {
        game.setGoals(goals);
    }
}
