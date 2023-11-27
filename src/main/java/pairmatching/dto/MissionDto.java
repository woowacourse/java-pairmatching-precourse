package pairmatching.dto;

import java.util.HashMap;
import java.util.List;

public class MissionDto {
    private static final HashMap<String, List<String>> missionMap = new HashMap<>();
    static {
        missionMap.put("레벨1", List.of("자동차경주","로또","숫자야구게임"));
        missionMap.put("레벨2", List.of("장바구니","결제","지하철노선도"));
        missionMap.put("레벨3", List.of());
        missionMap.put("레벨4", List.of("성능개선","배포"));
        missionMap.put("레벨5", List.of());
    }
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
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다");
        }

        validateCourse(input.get(0));
        validateLevel(input.get(1));
        validateMission(input);
    }


    private static void validateCourse(String course) {
        if (course.equals("백엔드") || course.equals("프론트엔드")) {
            return;
        }
        throw new IllegalArgumentException("존재하지 않는 과정입니다.");
    }

    private static void validateLevel(String level) {
        if(level.matches("레벨+[1-5]")){
            return;
        }
        throw new IllegalArgumentException("존재하지 않는 레벨입니다.");
    }

    private static void validateMission(List<String> input) {
        if (missionMap.get(input.get(1)).contains(input.get(2))) {
            return;
        }

        throw new IllegalArgumentException("존재하지 않는 미션입니다.");
    }

    public String getCourse() {
        return course;
    }

    public int getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }
}
