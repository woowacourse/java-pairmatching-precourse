package pairmatching.vo;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.repository.MissionRepository;

public class MatchingCommand {
    public static final String NOT_EXISTING_MISSION = "해당 레벨과 미션 이름에 일치하는 미션이 없음";
    private final Course course;
    private final Mission mission;

    public MatchingCommand(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public static MatchingCommand of(Course course, Level level, String missionName) {
        Validator.validate(level, missionName);
        return new MatchingCommand(course, Mission.of(level, missionName));
    }

    private static class Validator {
        public static void validate(Level level, String missionName) {
            if (!MissionRepository.isExistingWith(level, missionName)) {
                throw new IllegalArgumentException(NOT_EXISTING_MISSION);
            }
        }
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }
}
