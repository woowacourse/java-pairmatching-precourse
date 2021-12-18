package pairmatching.mission;

import pairmatching.pair.BackEndPair;
import pairmatching.pair.FrontEdnPair;

public class Mission {

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
}
