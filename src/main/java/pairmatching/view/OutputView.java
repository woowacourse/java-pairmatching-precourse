package pairmatching.view;

import java.util.LinkedHashMap;

import pairmatching.domain.Crew;
import pairmatching.domain.ProgramInfo;

public class OutputView {
    public static void showThisProgramPair(ProgramInfo programInfo) { // TODO 홀수 짝수 나눠서 해주기.
        System.out.println("\n페어 매칭 결과입니다.");
        LinkedHashMap<Crew, Crew> pairs = programInfo.getPairs();

        if (pairs.size() % 2 == 0) {
            for (Crew crew : pairs.keySet()) {
                System.out.println(crew + " : " + pairs.get(crew));
            }
            return;
        }
        // //홀수면
        // //마지막 3개를 하나로 뭉친다.
        int i = 0;
        for (Crew crew : pairs.keySet()) {
            if (i == pairs.size() - 2) {
                System.out.println(crew + " : " + pairs.get(crew) + " : " + pairs.get(pairs.get(crew)));
                break;
            }
            System.out.println(crew + " : " + pairs.get(crew));
            i += 1;
        }
        System.out.println("\n");
    }

    public static void showErrorMessage(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
