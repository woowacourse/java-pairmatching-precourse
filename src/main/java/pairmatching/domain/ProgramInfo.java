package pairmatching.domain;

public class ProgramInfo {
    Course course;
    Level level;
    Mission mission;

    public ProgramInfo(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }
}
