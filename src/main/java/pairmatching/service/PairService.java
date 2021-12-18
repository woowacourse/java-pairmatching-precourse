package pairmatching.service;

import pairmatching.domain.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PairService {

    public Matching matching(InputDTO input) {
        Matching matching = new Matching(input);
        List<Pair> result = pickCrew(input);
        if (result == null) {
            return null;
        }
        matching.addAllPairs(result);
        MatchingRepository.addMatching(matching);
        return matching;
    }

    public List<Pair> pickCrew(InputDTO input) {
        for (int i = 0; i < 3; i++) {
            List<Pair> result = tryToPickCrew(input);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public List<Pair> tryToPickCrew(InputDTO input) {
        List<String> shuffledCrew = Randoms.shuffle(CrewRepository.getCrewNames(input.getCourse()));
        List<Pair> result = new ArrayList<>();
        for (int i = 0; i + 2 < shuffledCrew.size(); i += 2) {
            Pair p = makePair(shuffledCrew.get(i), shuffledCrew.get(i + 1));
            if (isPicked(input, p)) {
                return null;
            }
            if (shuffledCrew.size() % 2 != 0 && i == shuffledCrew.size() - 3) {
                p.addCrew(CrewRepository.getCrewByName(shuffledCrew.get(i + 2)));
            }
            result.add(p);
        }
        return result;
    }

    public Pair makePair(String name1, String name2) {
        Crew c1 = CrewRepository.getCrewByName(name1);
        Crew c2 = CrewRepository.getCrewByName(name2);
        return new Pair(c1, c2);
    }

    public boolean isPicked(InputDTO input, Pair p) {
        List<Matching> matched = MatchingRepository.matchedList(input);
        for (Matching m : matched) {
            if (m.isSamePairs(p)) {
                return true;
            }
        }
        return false;
    }
}
