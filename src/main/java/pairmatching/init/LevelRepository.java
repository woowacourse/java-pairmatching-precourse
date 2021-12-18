package pairmatching.init;

import java.util.ArrayList;

public class LevelRepository {
    private static final ArrayList<Integer> levels = new ArrayList<>();

    static {
        levels.add(1);
        levels.add(2);
        levels.add(3);
        levels.add(4);
        levels.add(5);
    }

    public static ArrayList<Integer> getLevels() {
        return levels;
    }
}
