package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class Output {
    public static void printFunctionSelection() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭\n" +
                "2. 페어 조회\n" +
                "3. 페어 초기화\n" +
                "Q. 종료");
    }

    public static void printMissionAndProcess() {
        Mission mission = new Mission();
        System.out.println("\n#############################################");
        System.out.println("과정: " + Course.BACKEND.getName() + " | " + Course.FRONTEND.getName());
        System.out.println("미션:");
        System.out.println("  - 레벨1: " + String.join(" | ", mission.getLevelMission(Level.LEVEL1.getName())));
        System.out.println("  - 레벨2: " + String.join(" | ", mission.getLevelMission(Level.LEVEL2.getName())));
        System.out.println("  - 레벨3: " + String.join(" | ", mission.getLevelMission(Level.LEVEL3.getName())));
        System.out.println("  - 레벨4: " + String.join(" | ", mission.getLevelMission(Level.LEVEL4.getName())));
        System.out.println("  - 레벨5: " + String.join(" | ", mission.getLevelMission(Level.LEVEL5.getName())));
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }

    public static void printRematching() {
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
    }
}
