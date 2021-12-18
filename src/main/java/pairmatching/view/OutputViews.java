package pairmatching.view;

import pairmatching.domain.*;

import java.util.List;

public class OutputViews {
    public static void printMissionInfo(Missions missions) {
        System.out.println("\n#############################################");
        System.out.print("과정: ");
        System.out.println(String.join(" | ", Course.getList()));
        for (Level level : Level.getList()) {
            System.out.print("  - " + level.getName() + ": ");
            System.out.println(String.join(" | ", missions.getValue(level)));
        }
        System.out.println("#############################################");
    }

    public static void printMatchPair(MatchInfo matchInfo) {
        System.out.println("\n페어 매칭 결과입니다.");
        for (List<Crew> pair : matchInfo.getPairInfo()) {
            for (int i=0; i<pair.size()-1; i++) {
                System.out.print(pair.get(i) + " : ");
            }
            System.out.println(pair.get(pair.size()-1));
        }
    }
}
