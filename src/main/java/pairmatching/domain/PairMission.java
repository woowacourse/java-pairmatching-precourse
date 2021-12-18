package pairmatching.domain;

public class PairMission {
    private final Course course;
    private final Level level;

    public PairMission(String inputPairMission) {
        String[] splitPairMission = inputPairMission.split(", ", -1);
        this.course = Course.parseCourse(splitPairMission[0]);
        this.level = Level.parseLevel(splitPairMission[1], splitPairMission[2]);
    }
}