package pairmatching.vo;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

import java.util.Objects;

public class PairMatchingInfo {
    private final Course course;
    private final Mission mission;

    private PairMatchingInfo(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public static PairMatchingInfo of(Course course, Mission mission) {
        return new PairMatchingInfo(course, mission);
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return mission.getLevel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PairMatchingInfo that = (PairMatchingInfo) o;
        return course == that.course && mission.equals(that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, mission);
    }

    public boolean isLevel(Level level) {
        return this.getLevel().equals(level);
    }

    public boolean isCourse(Course course) {
        return this.getCourse().equals(course);
    }
}
