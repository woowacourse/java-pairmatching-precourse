package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
    private final List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public static Pairs createByNameList(List<String> names) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < names.size(); i += 2) {
            if (isThirdPair(names, i)) {
                handleThirdPair(names, pairs, i);
                break;
            }
            Pair newPair = new Pair(names.get(i), names.get(i + 1));
            pairs.add(newPair);
        }
        return new Pairs(pairs);
    }

    private static void handleThirdPair(List<String> names, List<Pair> pairs, int i) {
        Pair lastPair = pairs.get(pairs.size() - 1);
        lastPair.addCrew(names.get(i));
    }

    private static boolean isThirdPair(List<String> names, int i) {
        return i + 1 == names.size();
    }

    public boolean hasSamePair(Pairs source) {
        for (Pair pair : source.pairs) {
            for (Pair thisPair : this.pairs) {
                if (thisPair.hasSamePair(pair)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Pair> getPairs() {
        return new ArrayList<>(pairs);
    }
}
