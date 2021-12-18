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

    public static List<String> findMissonByLevel(Level level) {
        for(LevelMisson levelMisson : levelMissonList) {
            if(levelMisson.getLevel() == level) {
                return levelMisson.getMissons();
            }
        }
        throw new IllegalArgumentException("[ERROR] : 레벨을 찾을 수 없습니다.");
    }
}
