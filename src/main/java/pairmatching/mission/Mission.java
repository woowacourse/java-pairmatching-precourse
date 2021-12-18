package pairmatching.mission;

import java.util.Set;
import java.util.stream.Collectors;
import pairmatching.crew.Position;
import pairmatching.pair.BackEndPair;
import pairmatching.pair.FrontEdnPair;
import pairmatching.pair.Pair;

public class Mission {

    private static final String LINE_BREAK = "\n";
    private final Level level;
    private final String name;
    private final BackEndPair backEndPair = new BackEndPair(this);
    private final FrontEdnPair frontEdnPair = new FrontEdnPair(this);

    public Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public boolean isLevelMatched(Level level) {
        return this.level == level;
    }

    public BackEndPair getBackEndPair() {
        return backEndPair;
    }

    public FrontEdnPair getFrontEdnPair() {
        return frontEdnPair;
    }

    public boolean hasPair(Pair pair) {
        if (pair.getPosition() == Position.BACKEND) {
            return backEndPair.hasPair(pair);
        }
        return frontEdnPair.hasPair(pair);
    }

    public void registerPair(Pair pair) throws IllegalArgumentException {
        if (pair.getPosition() == Position.BACKEND) {
            backEndPair.addPair(pair);
            return;
        }
        frontEdnPair.addPair(pair);
    }

    public Set<Pair> getMatchedPair(Position position) {
        if (position == Position.BACKEND) {
            return backEndPair.pairs();
        }
        return frontEdnPair.pairs();
    }

    public String getMatchedResult(Position position) {
        return getMatchedPair(position).stream()
            .map(Pair::getMatching)
            .collect(Collectors.joining(LINE_BREAK));
    }

    public boolean isMatched(Position position) {
        if (position == Position.BACKEND) {
            return !backEndPair.isEmpty();
        }
        return !frontEdnPair.isEmpty();
    }

    public void init() {
        frontEdnPair.initPairs();
        backEndPair.initPairs();
    }
}
