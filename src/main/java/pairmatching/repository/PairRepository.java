package pairmatching.repository;

import pairmatching.domain.Category;
import pairmatching.domain.enumeration.Mission;
import pairmatching.domain.enumeration.Pairs;

import java.util.HashMap;
import java.util.Map;

public class PairRepository {
    private Map<Category, Pairs> pairsMap = new HashMap<>();

    public void createPairs(Category category, Pairs pairs) {
        pairsMap.put(category, pairs);
    }

    public Pairs findByCategory(Category category) {
        return pairsMap.get(category);
    }

}
