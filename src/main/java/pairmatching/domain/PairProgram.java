package pairmatching.domain;

public class PairProgram {

    private final Crews crews;
    private final LevelMission levelMission;

    public PairProgram(Crews crews, LevelMission levelMission) {
        this.crews = crews;
        this.levelMission = levelMission;
    }

    public boolean isAlreadyMatch(Level level, Mission mission) {
        levelMission.checkExistMission(level, mission);
        return levelMission.isAlreadyMatch(level, mission);
    }
}
