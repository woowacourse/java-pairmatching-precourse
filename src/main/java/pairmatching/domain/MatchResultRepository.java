package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchResultRepository {

    private static final List<MatchResult> matchResults = new ArrayList<>();

    public static List<MatchResult> getMatchResultsByOptions() { return matchResults; }

    public static void addMatchResult(MatchResult matchResult) {
        matchResults.add(matchResult);
    }

    public static void deleteMatchResults() { matchResults.clear(); }
}
