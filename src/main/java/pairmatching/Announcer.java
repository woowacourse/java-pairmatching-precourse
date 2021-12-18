package pairmatching;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Announcer {

    private static final String HASH_LINES = "#############################################";
    private static final String COURSE = "과정: ";
    private static final String MISSION = "미션: ";
    private static final String SELECT_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.";
    private static final String ERROR = "[ERROR]";
    private static final String REMATCH_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    private static final String YES_OR_NO = "네 | 아니오";

    public void announcePairMatchingSystem(List<Mission> missions) {
        System.out.println(HASH_LINES);
        List<String> courseNames = Arrays.stream(Course.values()).map(Course::getCourseName).collect(Collectors.toList());
        System.out.println(COURSE + String.join(" | ", courseNames));
        System.out.println(MISSION);
        List<Level> levels = Arrays.stream(Level.values()).collect(Collectors.toList());
        for (Level level : levels) {
            List<String> missionNamesByLevel = missions.stream().filter(mission -> mission.checkLevel(level)).map(Mission::getName)
                .collect(Collectors.toList());
            System.out.println(makeLevelPrintFormat(level) + String.join(" | ", missionNamesByLevel));
        }
        System.out.println(HASH_LINES);
        System.out.println(SELECT_COURSE_LEVEL_MISSION);
    }

    private String makeLevelPrintFormat(Level level) {
        return "    - " + level.getName() + ":  ";
    }

    public void errorMessage(String message) {
        System.out.println(ERROR + message);
    }

    public void requestRematching() {
        System.out.println(REMATCH_MESSAGE);
        System.out.println(YES_OR_NO);
    }

    public void announcePairMatchingResult(List<Partner> partners) {
        System.out.println("페어 매칭 결과입니다.");
        for (Partner partner1 : partners) {
            System.out.println(partner1.printFormatName());
        }
    }

    public void announceSelectFunction() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료");
    }
}
