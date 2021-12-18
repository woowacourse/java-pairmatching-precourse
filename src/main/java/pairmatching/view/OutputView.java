package pairmatching.view;

import pairmatching.domain.Crew;
import pairmatching.domain.Mission;

public class OutputView {
    private static String RESULT = "페어 매칭 결과입니다.";
    public static void printMatching(Mission mission){
        System.out.println(RESULT);
        mission.printPair();
    }
}
