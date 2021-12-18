package pairmatching.crew;

import pairmatching.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CrewRepository {
    static HashMap<Level,List<List<String>>> crews = new HashMap<>();

    public static void savePair(Level level, List<String> crew) {
        List<List<String>> pairs = crews.get(level);
        pairs.add(crew);
        crews.put(level, pairs);
    }
    
}
