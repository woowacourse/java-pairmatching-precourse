package pairmatching.view;

import java.util.List;
import pairmatching.domain.Match;

public class OutputView {

    private static final String MATCH_RESULT = "페어 매칭 결과입니다.";

    private static final String CLEAR_PROGRAME = "초기화 되었습니다.";

    private static final String NAME_DELEMITER = " : ";

    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printMatchResult(List<Match> matches) {
        System.out.println(MATCH_RESULT);
        matches.forEach(match -> System.out.println(printMatchPlayer(match.crewNames())));
        System.out.println();
    }

    private static String printMatchPlayer(List<String> names) {
        return String.join(NAME_DELEMITER, names);
    }

    public static void printInit() {
        System.out.println(CLEAR_PROGRAME);
    }
}
