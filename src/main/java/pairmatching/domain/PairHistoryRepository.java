package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairHistoryRepository {

    private static final List<PairHistory> histories = new ArrayList<>();

    public static List<PairHistory> getHistories() { return histories; }

    public static List<PairHistory> getHistoriesByLevel(Level level) {
        List<PairHistory> levelHistories = new ArrayList<>();
        for (PairHistory history : histories) {
            if (!history.getLevel().equals(level)) continue;
            levelHistories.add(history);
        }
        return levelHistories;
    }

    public static void addPairHistory(PairHistory pairHistory) {
        histories.add(pairHistory);
    }

    public static PairHistory findPairHistoryByCrewsAndLevel(List<Crew> partners, Level level) {
        for (PairHistory pairHistory : getHistoriesByLevel(level)) {
            if(!pairHistory.getPairs().containsAll(partners)) continue;
            return pairHistory;
        }
        return null;
    }
}
