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
            if (pair.containsAll(crew)) {
                return true;
            }
        }
        return false;
    }
}
