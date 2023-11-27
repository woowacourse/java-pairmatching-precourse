package pairmatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Pair {
    private List<String> crews;

    public Pair(String firstCrew, String secondCrew) {
        crews = new ArrayList<>();
        crews.add(firstCrew);
        crews.add(secondCrew);
    }

    public void addCrew(String crew) {
        crews.add(crew);
    }

    public List<String> getCrews() {
        return new ArrayList<>(crews);
    }


    public boolean hasSamePair(Pair pair) {
        if (crews.size() == 2 && pair.crews.size() == 2) {
            Set set = new HashSet<>();
            set.addAll(crews);
            set.addAll(pair.crews);
            return set.size() == 2;
        }
        if (crews.size() == 3 && pair.crews.size() == 3) {
            Set set = new HashSet<>();
            set.addAll(crews);
            set.addAll(pair.crews);
            return set.size() == 3;
        }
        return countDuplicateElements(crews, pair.crews) > 2;
    }

    private int countDuplicateElements(List<String> list1, List<String> list2) {
        Map<String, Integer> countMap = new HashMap<>();

        for (String str : list1) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        int duplicateCount = 0;

        for (String str : list2) {
            if (countMap.containsKey(str) && countMap.get(str) > 0) {
                duplicateCount++;
            }
        }

        return duplicateCount;
    }
}
