package pairmatching.view;

import java.util.LinkedHashMap;

import pairmatching.domain.Crew;
import pairmatching.domain.ProgramInfo;

public class OutputView {
    public static void showThisProgramPair(ProgramInfo programInfo) { // TODO 홀수 짝수 나눠서 해주기.
        System.out.println("\n페어 매칭 결과입니다.");
        LinkedHashMap<Crew, Crew> pairs = programInfo.getPairs();

        if (isEvenCnt(pairs))
            return;
        isOddCnt(pairs);
    }

    private static void isOddCnt(LinkedHashMap<Crew, Crew> pairs) {
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

    private static boolean isEvenCnt(LinkedHashMap<Crew, Crew> pairs) {
        if (pairs.size() % 2 == 0) {
            for (Crew crew : pairs.keySet()) {
                System.out.println(crew + " : " + pairs.get(crew));
            }
            System.out.println("\n");
            return true;
        }
        return false;
    }

    public static void showErrorMessage(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public static void showThisMissionIsNotMatchingMessage() {
        System.out.println("해당되는 미션은 아직 매칭되지 않았습니다.");
    }
}
