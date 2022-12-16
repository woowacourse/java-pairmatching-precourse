package pairmatching.domain.choice;

import pairmatching.domain.item.Course;
import pairmatching.domain.item.Mission;

import java.util.Objects;

public class Choice {

    private final Course course;
    private final Mission mission;

    public Choice(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Choice choice = (Choice) o;
        return course == choice.course && mission == choice.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, mission);
    }

    public boolean hasCourseOf(Course course) {
        return this.course.equals(course);
    }

    public boolean hasSameLevel(Choice choice) {
        return mission.isSameLevel(choice.mission);
    }
}
