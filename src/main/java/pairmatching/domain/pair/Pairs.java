package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pairs {

    private final List<Pair> pairs;

    private Pairs(final List<Pair> pairs) {
        this.pairs = pairs;
    }

    public static Pairs createPairs(List<String> names) {
        List<Pair> list = new ArrayList<>();
        while (names.size() != 0) {
            if (names.size() == 3) {
                list.add(Pair.valueOf(names.subList(0, 3)));
                removeNames(names, 3);
                continue;
            }
            list.add(Pair.valueOf(names.subList(0, 2)));
            removeNames(names, 2);
        }
        return new Pairs(list);
    }

    private static void removeNames(List<String> names, int index) {
        while (index-- != 0) {
            names.remove(0);
        }
    }

    public boolean contains(Pairs otherPairs) {
        for (Pair pair : otherPairs.pairs) {
            if (this.pairs.contains(pair)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return pairs.stream()
                .map(pair -> pair.toString())
                .collect(Collectors.joining("\n"));
    }
}
