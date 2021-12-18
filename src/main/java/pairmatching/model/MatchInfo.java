package pairmatching.model;

public class MatchInfo {
    private Course course;
    private Level level;
    private Mission mission;

    public MatchInfo(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
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
