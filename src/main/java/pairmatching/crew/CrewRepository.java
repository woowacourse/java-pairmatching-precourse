package pairmatching.crew;

import pairmatching.Level;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    static List<List<String>> levelOne = new ArrayList<>();
    static List<List<String>> levelTwo = new ArrayList<>();
    static List<List<String>> levelThree = new ArrayList<>();
    static List<List<String>> levelFour = new ArrayList<>();
    static List<List<String>> levelFive = new ArrayList<>();

    public static void savePair(Level level, List<String> crew) {
        if (level == Level.LEVEL1) {
            levelOne.add(crew);
        }
        if (level == Level.LEVEL2) {
            levelTwo.add(crew);
        }
        if (level == Level.LEVEL3) {
            levelThree.add(crew);
        }
        if (level == Level.LEVEL4) {
            levelFour.add(crew);
        }
        if (level == Level.LEVEL5) {
            levelFive.add(crew);
        }
    }
}
