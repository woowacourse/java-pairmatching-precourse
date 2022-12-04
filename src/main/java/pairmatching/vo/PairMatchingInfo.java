package pairmatching.vo;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;

import java.util.Objects;

public class PairMatchingInfo {
    private final Course course;
    private final Mission mission;

    public PairMatchingInfo(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
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
}
