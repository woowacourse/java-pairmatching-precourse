package pairmatching.view;

import java.util.List;
import pairmatching.Pair;

public class OutputView {
    public static void printException(Exception error) {
        System.out.println("[ERROR] : " + error.getMessage());
    }

    public static void printMatchingResult(List<Pair> matchingResult) {
        System.out.println("페어 매칭 결과입니다.");
        for (Pair pair : matchingResult) {
            String pairString = String.join(" : ", pair.getCrews());
            System.out.println(pairString);
        }
    }
}
