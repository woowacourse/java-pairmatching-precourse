package pairmatching.repository;

import pairmatching.domain.Category;
import pairmatching.domain.Pairs;

import java.util.HashMap;
import java.util.Map;

public class PairRepository {
    private static Map<Category, Pairs> pairsMap = new HashMap<>();

    public static void createPairs(Category category, Pairs pairs) {
        pairsMap.put(category, pairs);
    }

    public static Pairs findByCategory(Category category) {
        Pairs pairs = pairsMap.get(category);
        if(pairs == null) {
            return new Pairs();
        }
        return pairs;
    }

    public static void removeAll() {
        pairsMap.clear();
    }

}
