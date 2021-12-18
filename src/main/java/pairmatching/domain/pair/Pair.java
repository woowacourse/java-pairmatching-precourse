package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.mission.Mission;

public class Pair {
    private final String mission;
    private List<String> crewNames;
    private List<List<String>> sameLevelPairs;
    private List<List<String>> pairs;

    public Pair(String mission, List<String> crewNames, List<List<String>> sameLevelPairs) {
        this.mission = mission;
        this.crewNames = crewNames;
        this.sameLevelPairs = sameLevelPairs;
    }

    public void match() {
        boolean matchSuccess = false;
        pairs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            pairs = new ArrayList<>();
            crewNames = Randoms.shuffle(crewNames);
            if (match(crewNames)) {
                matchSuccess = true;
                break;
            }
        }
        if (!matchSuccess) {
            throw new IllegalArgumentException("매칭할 수 없습니다");
        }
    }

    private boolean match(List<String> crewNames) {
        for (int i = 0; i < crewNames.size() - 1; i += 2) {
            if (i == crewNames.size() - 1) {
                break;
            }
            List<String> pairCrewNames = createPairs(crewNames, i);
            if (!checkAvailable(pairCrewNames)) {
                return false;
            }
            pairs.add(pairCrewNames);
        }
        return true;
    }

    private List<String> createPairs(List<String> crewNames, int indexOfCrew) {
        List<String> pairCrewNames = new ArrayList<>();
        pairCrewNames.add(crewNames.get(indexOfCrew));
        pairCrewNames.add(crewNames.get(indexOfCrew + 1));
        if (indexOfCrew == crewNames.size() - 3) {
            pairCrewNames.add(crewNames.get(indexOfCrew + 2));
        }
        return pairCrewNames;
    }

    private boolean checkAvailable(List<String> pairToTry) {
        for (List<String> pairAlready : sameLevelPairs) {
            if(checkSamePair(pairAlready, pairToTry)) {
                return false;
            };
        }
        return true;
    }

    private boolean checkSamePair(List<String> pairAlready, List<String> pairToTry) {
        int count = 0;
        for (String crewName : pairToTry) {
            if(pairAlready.contains(crewName)) {
                count++;
            }
        }
        if(count >= 2) {
            return true;
        }
        return false;
    }

    public List<List<String>> getPairs() {
        return pairs;
    }
}



