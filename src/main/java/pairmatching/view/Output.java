package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class Output {
    private static final String SELECT_FUNCTION = "기능을 선택하세요.";
    private static final String BASE_PRINT = "#############################################";
    private static final String BASE_COURSE = "과정: ";
    private static final String BASE_MISSION = "미션:";
    private static final String SELECT_MISSION_COURSE_LEVEL = "과정, 레벨, 미션을 선택하세요.";
    private static final String SELECT_MISSION_COURSE_LEVEL_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String SELECT_REMATCHING = "\n매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    private static final String SELECT_YES_OR_NO = "네 | 아니오";
    private static final String SELECT_FUNCTION_LIST = "1. 페어 매칭\n" +
                                                        "2. 페어 조회\n" +
                                                        "3. 페어 초기화\n" +
                                                        "Q. 종료";

    public static void printFunctionSelection() {
        System.out.println(SELECT_FUNCTION);
        System.out.println(SELECT_FUNCTION_LIST);
    }

    public static void printMissionAndProcess() {
        Mission mission = new Mission();
        System.out.println("\n"+BASE_PRINT);
        System.out.println(BASE_COURSE + Course.BACKEND.getName() + " | " + Course.FRONTEND.getName());
        System.out.println(BASE_MISSION);
        System.out.println("  - "+ Level.LEVEL1.getName() + ": " + String.join(" | ", mission.getLevelMission(Level.LEVEL1.getName())));
        System.out.println("  - "+ Level.LEVEL2.getName() + ": " + String.join(" | ", mission.getLevelMission(Level.LEVEL2.getName())));
        System.out.println("  - "+ Level.LEVEL3.getName() +": " + String.join(" | ", mission.getLevelMission(Level.LEVEL3.getName())));
        System.out.println("  - "+ Level.LEVEL4.getName() +": " + String.join(" | ", mission.getLevelMission(Level.LEVEL4.getName())));
        System.out.println("  - "+ Level.LEVEL5.getName() +": " + String.join(" | ", mission.getLevelMission(Level.LEVEL5.getName())));
        System.out.println(BASE_PRINT);
    }

    public static void printMissionAndProcessSelect() {
        System.out.println(SELECT_MISSION_COURSE_LEVEL);
        System.out.println(SELECT_MISSION_COURSE_LEVEL_EXAMPLE);
    }

    public static void printRematching() {
        System.out.println(SELECT_REMATCHING);
        System.out.println(SELECT_YES_OR_NO);
    }
}
