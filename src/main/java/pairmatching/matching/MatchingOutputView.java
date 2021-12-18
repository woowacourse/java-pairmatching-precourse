package pairmatching.matching;

import java.util.List;

public class MatchingOutputView {

    public static void seeMatchingResult(List<String> allMatched) {
        System.out.println();
        System.out.println("페어 매칭 결과입니다.");
        // 결과 출력
        for (String matching : allMatched) {
            System.out.println(matching);
        }
        System.out.println();
    }

    public static void resetFinishedPrint() {
        System.out.println();
        System.out.println("초기화 되었습니다. ");
        System.out.println();
    }
}
