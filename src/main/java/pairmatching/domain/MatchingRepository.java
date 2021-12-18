package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingRepository {
    private static List<Matching> matchings = new ArrayList<>();

    public static boolean isMatched(InputDTO input) {
        return matchings.stream().filter(m -> m.isSame(input)).findFirst().orElse(null) == null;
    }

    public static Matching getMatching(InputDTO input) {
        return matchings.stream().filter(m -> m.isSame(input)).findFirst().orElse(null);
    }

    public static List<Matching> matchedList(InputDTO input) {
        return matchings.stream().filter(m -> m.isSame(input)).collect(Collectors.toList());
    }

    public static void addMatching(Matching m) {
        matchings.add(m);
    }

    public static void clearList() {
        matchings.clear();
    }
}
