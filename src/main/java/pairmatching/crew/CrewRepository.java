package pairmatching.crew;

import pairmatching.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CrewRepository {
    static HashMap<Level,List<List<String>>> crews = new HashMap<>();

    public static void savePair(Level level, List<List<String>> crew) {
        crews.put(level, crew);
    }

    public static boolean checkDuplicated(Level level, List<String> crew) {
        List<List<String>> pairs = crews.get(level);
        for (List<String> pair : pairs) {
            if (pair.contains(crew.get(0)) && pair.contains(crew.get(1))) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkExist(Level level, List<String> crew) {
        if (crews.containsKey(level)) {
            return checkDuplicated(level, crew);
        }
        return false;
    }
}
