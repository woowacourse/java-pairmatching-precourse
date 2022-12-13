package pairmatching.domain;

public class SearchingInfoDto {

    private final Course course;
    private final Level level;
    private final Mission mission;

    public SearchingInfoDto(Course course, Level level, Mission mission){
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
