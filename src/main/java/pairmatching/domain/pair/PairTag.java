package pairmatching.domain.pair;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.Objects;

public class PairTag {

    private final Course course;
    private final Level level;
    private final String missionName;

    public PairTag(Course course, Level level, String missionName) {
        this.course = course;
        this.level = level;
        this.missionName = missionName;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public boolean isSame(Course course) {
        return this.course == course;
    }

    public boolean isSame(Level level) {
        return this.level == level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairTag pairTag = (PairTag) o;
        return course == pairTag.course && level == pairTag.level && Objects.equals(missionName, pairTag.missionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, missionName);
    }
}
