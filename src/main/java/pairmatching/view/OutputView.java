package pairmatching.view;

import pairmatching.domain.*;

import java.util.List;

public class OutputView {
    public static void printMissionInfo(Missions missions) {
        System.out.println("\n#############################################");
        System.out.print("과정: ");
        System.out.println(String.join(" | ", Course.getList()));
        System.out.println("미션: ");
        for (Level level : Level.getList()) {
            System.out.print(" - " + level.getName() + ": ");
            System.out.println(String.join(" | ", missions.getValue(level)));
        }
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택해주세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }

    public static void printMatchPair(MatchInfo matchInfo) {
        System.out.println("\n페어 매칭 결과입니다. ");
        for(List<Crew> pair : matchInfo.getPairInfo()) {
            for(int i = 0; i < pair.size()-1; i++) {
                System.out.println(pair.get(i) + " : ");
            }
            System.out.println(pair.get(pair.size()-1));
        }
    }
}
