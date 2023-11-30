package pairmatching.validator;

import pairmatching.domain.Course;
import pairmatching.domain.constants.Position;
import pairmatching.domain.constants.Level;

public class InputCourseValidator {
    public static Course validateInputCourse(String inputCourse) {
        validateInput(inputCourse);
        String[] parts = inputCourse.split(", ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 잘못되었습니다.");
        }

        Position position = validatePosition(parts[0]);
        Level level = validateLevel(parts[1]);
        String mission = validateMission(level, parts[2]);
        return new Course(level, position, mission);
    }

    private static void validateInput(String course){
        if(course == null || course.isEmpty()){
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    private static Position validatePosition(String part) {
        for (Position position : Position.values()) {
            if (position.getPosition().equals(part)) {
                return position;
            }
        }
        throw new IllegalArgumentException("[ERROR] 백엔드, 프론트엔드 중에 입력해주세요.");
    }

    private static Level validateLevel(String part) {
        for (Level level : Level.values()) {
            if (level.getName().equals(part)) {
                return level;
            }
        }
        throw new IllegalArgumentException("[ERROR] 레벨1, 레벨2, 레벨3, 레벨4, 레벨5 중에 입력해주세요.");
    }

    private static String validateMission(Level level, String part) {
        if (level.getMissions() == null) {
            throw new IllegalArgumentException("[ERROR] 현재 " + level.getName() + "은 미션을 지원하지 않습니다.");
        }
        for (String mission : level.getMissions()) {
            if (mission.equals(part)) {
                return mission;
            }
        }
        throw new IllegalArgumentException("[ERROR] " + level.getName() + "의 미션 중에 입력해주세요.");
    }

}
