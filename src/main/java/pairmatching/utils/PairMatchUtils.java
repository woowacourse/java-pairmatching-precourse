package pairmatching.utils;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewRepository;
import pairmatching.domain.Pair;

import java.util.ArrayList;
import java.util.List;

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
}
