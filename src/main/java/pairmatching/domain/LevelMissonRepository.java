package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pairmatching.enums.Level;

public class LevelMissonRepository {
    List<LevelMisson> levelMissonList;

    public LevelMissonRepository() {
        levelMissonList = new ArrayList<>();
    }

    public void addMission(LevelMisson levelMisson) {
        levelMissonList.add(levelMisson);
    }

    public List<LevelMisson> getLevelMissonList() {
        return Collections.unmodifiableList(levelMissonList);
    }
}
