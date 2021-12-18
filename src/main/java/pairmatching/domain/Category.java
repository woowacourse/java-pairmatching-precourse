package pairmatching.domain;

import pairmatching.domain.enumeration.Course;
import pairmatching.domain.enumeration.Mission;

import java.util.Objects;

public class Category {
    private Mission mission;
    private Course course;

    public Mission getMission() {
        return mission;
    }

    public Course getCourse() {
        return course;
    }

    public Category(Mission mission, Course course) {
        this.mission = mission;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return mission == category.mission && course == category.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mission, course);
    }
}
