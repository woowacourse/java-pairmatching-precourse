package pairmatching.model.crew;

import java.util.List;
import java.util.Objects;

public class CourseAndMission {
    private final Course course;
    private final Mission mission;

    public static CourseAndMission of(final List<String> courseAndLevelAndMission) {
        Course course = Course.of(courseAndLevelAndMission.get(0));
        Mission mission = Mission.of(courseAndLevelAndMission.get(1), courseAndLevelAndMission.get(2));
        return new CourseAndMission(course, mission);
    }

    private CourseAndMission(final Course course, final Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseAndMission that = (CourseAndMission) o;
        return course == that.course && mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, mission);
    }
}
