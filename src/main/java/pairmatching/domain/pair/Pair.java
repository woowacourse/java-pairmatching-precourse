package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pairmatching.Utils;

public class Pair {
    private final List<String> crews;

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
        return Utils.countDuplicateElements(crews, pair.crews) > 2;
    }
}
