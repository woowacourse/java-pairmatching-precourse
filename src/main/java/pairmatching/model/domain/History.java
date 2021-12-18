package pairmatching.model.domain;

import java.util.List;

public class History {
    private final Options options;
    private final List<Pair> pairs;

    public History(Options options, List<Pair> pairs) {
        this.options = options;
        this.pairs = pairs;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public boolean isSameHistory(Options otherOptions) {
        return options.equals(otherOptions);
    }
}
