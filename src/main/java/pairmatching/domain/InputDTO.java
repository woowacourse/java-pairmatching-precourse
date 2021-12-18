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

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }

    public Course getCourse() {
        return course;
    }

}
