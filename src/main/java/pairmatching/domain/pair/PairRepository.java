package pairmatching.domain.pair;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairRepository {

    private static final Map<PairTag, List<Pair>> store = new HashMap<>();


    public static boolean hasPairs(PairTag pairTag) {
        return store.containsKey(pairTag);
    }

    public static List<Pair> getPairsIn(Course course, Level level) {
        List<Pair> pairs = new ArrayList<>();
        store.keySet().stream()
                .filter(key -> key.isSame(course) && key.isSame(level))
                .forEach(key -> pairs.addAll(store.get(key)));
        return pairs;
    }

    public static void save(PairTag pairTag, List<Pair> result) {
        store.put(pairTag, result);
    }

    public static void clear(PairTag pairTag) {
        store.remove(pairTag);
    }
}
