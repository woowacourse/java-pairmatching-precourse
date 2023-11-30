package pairmatching.service;

import static pairmatching.exception.ErrorCode.INVALID_INPUT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pairmatching.domain.Crew;
import pairmatching.domain.PairHistory;

public class MatchingService {

    private static final int MAX_ATTEMPTS = 3;

    public static List<Crew> matchingPair(List<Crew> crews) {
        PairHistory pairHistory = new PairHistory();
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            List<Crew> shuffledCrews = Randoms.shuffle(crews);
            if (isMatchingPossible(shuffledCrews, pairHistory)) {
                updatePairHistory(shuffledCrews, pairHistory);
                return shuffledCrews;
            }
            int finalAttempt = attempt;
            INVALID_INPUT.validate(() -> attemptOver(finalAttempt));
        }
        return crews;
    }

    private static boolean isMatchingPossible(List<Crew> shuffledCrews, PairHistory pairHistory) {
        for (int i = 0; i < shuffledCrews.size() - 1; i += 2) {
            Crew crew1 = shuffledCrews.get(i);
            Crew crew2 = shuffledCrews.get(i + 1);
            if (pairHistory.werePairedBefore(crew1, crew2)) {
                return false;
            }
        }
        return true;
    }

    private static void updatePairHistory(List<Crew> shuffledCrews, PairHistory pairHistory) {
        for (int i = 0; i < shuffledCrews.size() - 1; i += 2) {
            Crew crew1 = shuffledCrews.get(i);
            Crew crew2 = shuffledCrews.get(i + 1);
            pairHistory.addPair(crew1, crew2);
        }
        if (shuffledCrews.size() % 2 != 0) {
            Crew lastCrew = shuffledCrews.get(shuffledCrews.size() - 1);
            Crew lastPairFirstCrew = shuffledCrews.get(shuffledCrews.size() - 2);
            pairHistory.addPair(lastCrew, lastPairFirstCrew);
        }
    }

    //== Validation Method ==//
    private static boolean attemptOver(final int attempt){
        return attempt == MAX_ATTEMPTS;
    }
}
