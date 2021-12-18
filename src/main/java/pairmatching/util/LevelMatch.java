package pairmatching.util;

import pairmatching.Level;

public class LevelMatch {
    public static Level getLevel(String level) {
        Level[] all = Level.values();
        for (Level l : all) {
            if (l.getName().equals(level)) {
                return l;
            }
        }
        return null;
    }
}
