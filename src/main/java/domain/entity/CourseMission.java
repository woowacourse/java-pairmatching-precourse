package domain.entity;

import java.util.List;

public class CourseMission {
    private final Course course;
    private final Level level;
    private final String mission; // TODO: 시간되면 VO 분리

    private CourseMission(Course course, Level level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static CourseMission create(Course course, Level level, String missionName) {
        return new CourseMission(course, level, missionName);
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }
}
