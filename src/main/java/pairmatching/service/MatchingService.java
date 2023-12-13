package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.MatchingConditions;
import pairmatching.domain.MatchingRepository;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.util.MDParser;

public class MatchingService {

    private final MatchingRepository matchingRepository;

    public MatchingService() {
        this.matchingRepository = new MatchingRepository();
    }

    public Pairs matchPair(MatchingConditions matchingConditions) {
        List<String> crewNames = getCrews(matchingConditions);
        List<Crew> crews = mixRandomly(crewNames);
        Pairs pairs = makePairs(crews, matchingConditions);
        matchingRepository.add(pairs);
        return pairs;
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
