package pairmatching.domain;

import java.util.Objects;

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

    public Course getCourse() {
        return course;
    }

    public boolean isSameLevel(PairMission pairMission) {
        return this.level == pairMission.level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PairMission that = (PairMission)o;
        return course == that.course && level == that.level && Objects.equals(mission, that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}