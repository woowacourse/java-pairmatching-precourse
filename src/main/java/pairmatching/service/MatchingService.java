package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.MatchingConditions;
import pairmatching.domain.MatchingRepository;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.exception.ExceptionMessage;
import pairmatching.util.MDParser;

public class MatchingService {

    private static final int NUMBER_OF_LOOPS = 3;
    private final MatchingRepository matchingRepository;

    public MatchingService() {
        this.matchingRepository = new MatchingRepository();
    }

    public Pairs matchPair(MatchingConditions matchingConditions) {
        Pairs pairs;
        List<String> crewNames = getCrews(matchingConditions);
        pairs = getPairs(matchingConditions, crewNames);
        return pairs;
    }

    private Pairs getPairs(MatchingConditions matchingConditions, List<String> crewNames) {
        Pairs pairs;
        int count = 0;
        while (true) {
            checkNumberOfLoops(count);
            List<Crew> crews = mixRandomly(crewNames);
            pairs = makePairs(crews, matchingConditions);
            if (matchingRepository.hasPairs(matchingConditions, pairs)) {
                count++;
                continue;
            }
            matchingRepository.add(pairs);
            break;
        }
        return pairs;
    }

    private void checkNumberOfLoops(int count) {
        if (count == NUMBER_OF_LOOPS) {
            throw new IllegalArgumentException(ExceptionMessage.FAIL_MATCHING.getMessage());
        }
    }

    private List<String> getCrews(MatchingConditions matchingConditions) {
        MDParser mdParser = new MDParser();
        return mdParser.parserCrewData(matchingConditions.getCourse());
    }

    private List<Crew> mixRandomly(List<String> crewNames) {
        List<String> shuffle = Randoms.shuffle(crewNames);
        List<Crew> crews = new ArrayList<>();
        for (String name : shuffle) {
            crews.add(new Crew(name));
        }
        return crews;
    }

    private Pairs makePairs(List<Crew> crews, MatchingConditions matchingConditions) {
        Pairs pairs = new Pairs(matchingConditions);
        for (int i = 0; i < crews.size(); i += 2) {
            Pair pair = new Pair();
            pair.add(crews.get(i));
            pair.add(crews.get(i + 1));
            if (crews.size() % 2 == 1 && i == crews.size() - 3) {
                pair.add(crews.get(i + 2));
                pairs.add(pair);
                break;
            }
            pairs.add(pair);
        }
        return pairs;
    }

    public Pairs findPairs(MatchingConditions matchingConditions) {
        return matchingRepository.search(matchingConditions);
    }

    public void resetData() {
        matchingRepository.reset();
    }

    public boolean hasConditions(MatchingConditions matchingConditions) {
        return matchingRepository.hasConditionsPair(matchingConditions);
    }
}
