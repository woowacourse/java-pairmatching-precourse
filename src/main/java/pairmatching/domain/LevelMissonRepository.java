package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pairmatching.enums.Level;

public class LevelMissonRepository {
    private static List<LevelMisson> levelMissonList = new ArrayList<>();

    public static void addMission(LevelMisson levelMisson) {
        levelMissonList.add(levelMisson);
    }

    public static List<LevelMisson> getLevelMissonList() {
        return Collections.unmodifiableList(levelMissonList);
    }
}
