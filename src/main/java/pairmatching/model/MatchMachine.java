package pairmatching.model;

import java.util.List;

public class MatchMachine {
    private final MatchGenerator generator;
    private final List<History> historys;

    public MatchMachine(MatchGenerator generator, List<History> historys) {
        this.generator = generator;
        this.historys = historys;
    }

    public History createPair(Options options) {
        return new History(options, generator.createPairs(options, new FileScanner()));
    }


}
