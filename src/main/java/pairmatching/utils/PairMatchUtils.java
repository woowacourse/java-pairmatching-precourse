package pairmatching.utils;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewRepository;
import pairmatching.domain.Level;
import pairmatching.domain.Pair;
import pairmatching.domain.PairHistory;
import pairmatching.domain.PairHistoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pairmatching.constants.SystemConstants.NO;
import static pairmatching.constants.SystemConstants.YES;
import static pairmatching.utils.UserChoiceValidator.validateYesNoInput;
import static pairmatching.view.InputView.requestNewMatchInput;

public class PairMatchUtils {

    public static List<Pair> returnMatchResult() {
        List<Crew> crewList = getRandomCrewList();
        List<Pair> pairs = returnMatchResultOnEven(crewList);
        if(crewList.size()%2 == 1) {
            pairs.get(pairs.size()-1).addCrew(crewList.get(crewList.size()-1));
        }
        return pairs;
    }

    private static List<Crew> getRandomCrewList() {
        List<Crew> crews = new ArrayList<>();
        for (String crewName : getRandomCrewNames()) {
            crews.add(CrewRepository.getCrewByName(crewName));
        }
        return crews;
    }

    private static List<String> getRandomCrewNames() {
        List<String> crewNames = new ArrayList<>();
        for (Crew crew : CrewRepository.getCrews()) {
            crewNames.add(crew.getName());
        }
        return Randoms.shuffle(crewNames);
    }

    private static List<Pair> returnMatchResultOnEven(List<Crew> crewList) {
        List<Pair> pairs = new ArrayList<>();
        int pairNum = crewList.size()/2;
        for (int idx = 0; idx < pairNum; idx++) {
            pairs.add(new Pair(crewList.get(2*idx), crewList.get(2*idx + 1)));
        }
        return pairs;
    }

    public static boolean validateNoDuplicateHistory(List<Pair> pairs, Level level) {
        for (Pair pair : pairs) {
            PairHistory history = PairHistoryRepository.findPairHistoryByCrewsAndLevel(pair.getCrews(), level);
            if (history != null) {
                return false;
            }
        }
        Pair lastPair = pairs.get(pairs.size()-1);
        if (lastPair.getCrews().size() != 3) return true;
        return validateNoDuplicateHistoryInThreePartners(lastPair, level);
    }

    public static boolean validateNoDuplicateHistoryInThreePartners(Pair pair, Level level) {
        List<List<Crew>> miniPairs = new ArrayList<>();
        miniPairs.add(Stream.of(pair.getCrews().get(0), pair.getCrews().get(1)).collect(Collectors.toList()));
        miniPairs.add(Stream.of(pair.getCrews().get(0), pair.getCrews().get(2)).collect(Collectors.toList()));
        miniPairs.add(Stream.of(pair.getCrews().get(1), pair.getCrews().get(2)).collect(Collectors.toList()));

        for (List<Crew> miniPair : miniPairs) {
            PairHistory history = PairHistoryRepository.findPairHistoryByCrewsAndLevel(miniPair, level);
            if (history != null) {
                return false;
            }
        }
        return true;
    }
}
