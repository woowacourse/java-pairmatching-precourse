package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import pairmatching.domain.MatchingInfo;
import pairmatching.domain.pair.Pairs;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MatchingInfoRepository;

public class MatchingService {

    private static final int MAX_MATCH_TRY_COUNT = 3;
    private final MatchingInfoRepository matchingInfoRepository = new MatchingInfoRepository();


    public Pairs saveCrewsByInfo(MatchingInfo matchingInfo) {
        Pairs shufflePairs;

        int matchCount = 0;
        while (true) {
            validateMatchTryCount(matchCount);

            shufflePairs = getShufflePairs(matchingInfo);
            if (existPair(matchingInfo, shufflePairs)) {
                break;
            }
            matchCount++;
        }
        return shufflePairs;
    }

    public boolean isMatchInfo(MatchingInfo matchingInfo) {
        return matchingInfoRepository.hasInfo(matchingInfo);
    }

    public Pairs getPairsByMatchInfo(MatchingInfo matchingInfo) {
        Pairs pairs = matchingInfoRepository.getPairs(matchingInfo);
        if (pairs == null) {
            throw new IllegalArgumentException("매칭 이력이 없습니다.\n");
        }
        return pairs;
    }

    public void clearRepository() {
        matchingInfoRepository.clearRepository();
    }

    private boolean existPair(MatchingInfo matchingInfo, Pairs shufflePairs) {
        if (matchingInfoRepository.nonexistentPutMatchingInfo(matchingInfo, shufflePairs)) {
            return true;
        }
        return false;
    }

    private static void validateMatchTryCount(int matchCount) {
        if (matchCount == MAX_MATCH_TRY_COUNT) {
            throw new IllegalStateException("페어 매칭이 3회 실패했습니다.");
        }
    }

    private Pairs getShufflePairs(MatchingInfo matchingInfo) {
        List<String> names = CrewRepository.getNames(matchingInfo.getCourse());

        return Pairs.createPairs(Randoms.shuffle(names));
    }
}
