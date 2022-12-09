package pairmatching.domain;

import java.util.List;

public class PairMatchingRepository {
    private List<PairMatchingRecord> records;

    public boolean isExistingChoice(MatchingChoice matchingChoice){
        return records.stream()
                .map(PairMatchingRecord::getMatchingChoice)
                .anyMatch(matchingChoice::equals);
    }
}
