package pairmatching.domain;

import java.util.Arrays;

public class InputDTO {
    Course course;
    Level level;
    Mission mission;

    public InputDTO(String course, String level, String mission) {
        this.course = Arrays.stream(Course.values()).filter(c -> c.isSameName(course)).findFirst().orElse(null);
        this.level = Arrays.stream(Level.values()).filter(l -> l.isSameName(level)).findFirst().orElse(null);
        this.mission = MissionRepository.getMissionByName(mission);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    @Override
    public String toString() {
        return "InputDTO{" +
                "course=" + course +
                ", level=" + level +
                ", mission=" + mission +
                '}';
    }
}
