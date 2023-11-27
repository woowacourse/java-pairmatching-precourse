package pairmatching.view;

import pairmatching.domain.pair.Pair;
import pairmatching.domain.pair.Pairs;

public class OutputView {
    public static void printException(Exception error) {
        System.out.println("[ERROR] : " + error.getMessage());
    }

    public static void printMatchingResult(Pairs matchingResult) {
        System.out.println("페어 매칭 결과입니다.");
        for (Pair pair : matchingResult.getPairs()) {
            String pairString = String.join(" : ", pair.getCrews());
            System.out.println(pairString);
        }
    }
}
