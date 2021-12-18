package pairmatching.domain.pair;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.*;

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

    public static void clear() {
        store.clear();
    }

    public static List<Pair> get(PairTag pairTag) {
        List<Pair> pairs = store.get(pairTag);
        if (pairs == null) {
            return Collections.EMPTY_LIST;
        }
        return pairs;
    }
}
