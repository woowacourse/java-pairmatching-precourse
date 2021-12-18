package pairmatching.view;

import pairmatching.domain.Level;
import pairmatching.domain.MatchResult;
import pairmatching.domain.Pair;

import static pairmatching.constants.OutputMessages.*;

public class OutputView {

    public static void showBackgroundInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(DIVIDER);
        sb.append(COURSES);
        sb.append(MISSION);
        for (Level level : Level.values()) {
            sb.append(MISSION_FORMAT(level));
        }
        sb.append(DIVIDER);
        System.out.println(sb);
    }

    public static void showMatchResult(MatchResult matchResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(MATCH_RESULT);
        for (Pair pair : matchResult.getPairs()) {
            sb.append(PAIR_FORMAT(pair));
        }
        System.out.println(sb);
    }
}
