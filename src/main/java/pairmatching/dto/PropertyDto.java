package pairmatching.dto;

import java.util.Objects;

public class PropertyDto {
    private final String course;
    private final String level;
    private final String mission;

    public PropertyDto(String course, String level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        PropertyDto other = (PropertyDto) object;
        return this.course.equals(other.course) && this.level.equals(other.level) && this.mission.equals(other.mission);
    }

    public String getCourse() {
        return course;
    }

    public String getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }
}
