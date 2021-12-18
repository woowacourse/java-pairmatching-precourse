package pairmatching.view;

import pairmatching.domain.*;

import java.util.List;

public class OutputViews {
    public static final String MISSION_INFO_FRONT_BOX = "\n#############################################";
    public static final String MISSION_INFO_BACK_BOX = "#############################################";
    public static final String LEVEL_FRONT = "  - ";
    public static final String LEVEL_BACK = ": ";
    public static final String MISSION_SEPORATOR = " | ";
    public static final String MATCHING_SEPORATOR = " : ";

    public static void printMissionInfo(Missions missions) {
        System.out.println(MISSION_INFO_FRONT_BOX);
        System.out.print("과정: ");
        System.out.println(String.join(MISSION_SEPORATOR, Course.getList()));
        for (Level level : Level.getList()) {
            System.out.print(LEVEL_FRONT + level.getName() + LEVEL_BACK);
            System.out.println(String.join(MISSION_SEPORATOR, missions.getValue(level)));
        }
        System.out.println(MISSION_INFO_BACK_BOX);
    }

    public static void printMatchPair(MatchInfo matchInfo) {
        System.out.println("\n페어 매칭 결과입니다.");
        for (List<Crew> pair : matchInfo.getPairInfo()) {
            for (int i = 0; i < pair.size() - 1; i++) {
                System.out.print(pair.get(i) + MATCHING_SEPORATOR);
            }
            System.out.println(pair.get(pair.size() - 1));
        }
    }

    public static void printInitialize() {
        System.out.println("\n초기화 되었습니다. ");
    }
}
