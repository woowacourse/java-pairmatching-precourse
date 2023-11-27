package pairmatching.domain.entity;

import java.util.Objects;

public class CourseMission {
    private final Course course;
    private final Level level;
    private final Mission mission;

    private CourseMission(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static CourseMission create(Course course, Level level, Mission mission) {
        return new CourseMission(course, level, mission);
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        CourseMission compared = (CourseMission) other;
        return course.equals(compared.getCourse()) &&
                level.equals(compared.getLevel()) &&
                mission.equals(compared.getMission());
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
