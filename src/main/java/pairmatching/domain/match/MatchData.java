package pairmatching.domain.match;

public class MatchData {
    private Course course;
    private Mission mission;

    public MatchData(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }
}
