package pairmatching.view;

import java.util.LinkedHashMap;

import pairmatching.domain.Crew;
import pairmatching.domain.ProgramInfo;

public class OutputView {
    public static void showThisProgramPair(ProgramInfo programInfo) { // TODO 홀수 짝수 나눠서 해주기.
        LinkedHashMap<Crew, Crew> pairs = programInfo.getPairs();
        for (Crew crew : pairs.keySet()) {
            System.out.println(crew + " : " + pairs.get(crew));
        }
    }

    public static void showErrorMessage(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
