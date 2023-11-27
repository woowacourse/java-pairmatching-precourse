package domain.entity;

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
}
