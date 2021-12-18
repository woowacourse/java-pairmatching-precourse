package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
    private final List<Pair> pairs = new ArrayList<>();

    public void add(Pair pair) {
        pairs.add(pair);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pair pair : pairs) {
            stringBuilder.append(pair.toString() + "\n");
        }
        return stringBuilder.toString();
    }
}
