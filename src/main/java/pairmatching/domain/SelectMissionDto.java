package pairmatching.domain;

public class SelectMissionDto {
    Course course;
    Level level;
    String mission;

    public SelectMissionDto(Course course, Level level, String mission) {
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

    public String getMission() {
        return mission;
    }
}
