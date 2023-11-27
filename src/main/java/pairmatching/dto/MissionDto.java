package pairmatching.dto;

import java.util.List;
import java.util.Objects;

public class MissionDto {
    private final String course;
    private final int level;
    private final String mission;

    private MissionDto(String course, String level, String mission) {
        this.course = course;
        this.level = Integer.parseInt(level.replace("레벨", ""));
        this.mission = mission;
    }

    public static MissionDto from(List<String> input){
        validateInput(input);
        return new MissionDto(input.get(0), input.get(1), input.get(2));
    }

    private static void validateInput(List<String> input) {
        if(input.size() != 3){
            //todo
            throw new IllegalArgumentException();
        }
        validateCourse(input.get(0));
        validateLevel(input.get(1));
    }


    private static void validateCourse(String course) {
        if (course.equals("백엔드") || course.equals("프론트엔드")) {
            return;
        }
        //todo
        throw new IllegalArgumentException();
    }

    private static void validateLevel(String level) {
        if(level.matches("레벨+[1-5]")){
            return;
        }
        //todo
        throw new IllegalArgumentException();
    }
}
