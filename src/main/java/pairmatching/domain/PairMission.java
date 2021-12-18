package pairmatching.domain;

public class PairMission {
    private final Course course;
    private final Level level;
    private final String mission;

    public PairMission(String inputPairMission) {
        String[] splitPairMission = inputPairMission.split(", ", -1);
        validateInputSize(splitPairMission.length);

        this.course = Course.parseCourse(splitPairMission[0]);
        this.level = Level.parseLevel(splitPairMission[1], splitPairMission[2]);
        this.mission = splitPairMission[2];
    }

    private void validateInputSize(int length) {
        if (length != 3) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식입니다.");
        }
    }
}