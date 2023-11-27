package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
    private List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public static Pairs createByNameList(List<String> names) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < names.size(); i += 2) {
            if (i + 1 == names.size()) {
                Pair lastPair = pairs.get(pairs.size() - 1);
                lastPair.addCrew(names.get(i));
                break;
            }
            Pair pair = new Pair(names.get(i), names.get(i + 1));
            pairs.add(pair);
        }
        return new Pairs(pairs);
    }

    public List<Pair> getPairs() {
        return new ArrayList<>(pairs);
    }
}
