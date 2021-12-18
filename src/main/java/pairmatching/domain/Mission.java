package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mission {
    private final String missonName;
    private List<String> crewNames;
    private List<Set<String>> pairs;
    private List<String> suffledCrew;

    public Mission(String missonName, List<String> crews) {
        this.missonName = missonName;
        this.crewNames = crews;
        this.pairs = new ArrayList<>();
    }

    public void pairMathingList(MissionList missionList, Level level) {
        int matchingCount = 1;
        pairMatching(missionList, level);
        while (checkDuplication(missionList, level)) {

            if (matchingCount == 3){
                throw new IllegalArgumentException("[ERROR] 3회 이상 중복됐습니다.");
            }

            pairMatching(missionList, level);
            matchingCount+=1;
        }
    }

    private void pairMatching(MissionList missionList, Level level) {
        this.suffledCrew = Randoms.shuffle(crewNames);
        matchingPair();
    }

    public String getMissonName() {
        return missonName;
    }

    public List<Set<String>> getPairs() {
        return pairs;
    }

    public boolean checkMatchingHistory() {
        if (pairs.isEmpty()) {
            return false;
        }
        return true;
    }

    private void matchingPair() {
        int checkMatchingNumber = 0;
        int listLength = this.suffledCrew.size();
        for (int i = 0; i < listLength; i += 2) {
            Set<String> crews = new HashSet<>();
            if (listLength % 2 != 0 && i + 3 == listLength) {
                createOddCrew(crews, i);
                break;
            }
            createEvenCrew(crews, i);
        }
    }


    private void createOddCrew(Set<String> crews, int i) {
        crews.add(this.suffledCrew.get(i));
        crews.add(this.suffledCrew.get(i + 1));
        crews.add(this.suffledCrew.get(i + 2));
        pairs.add(crews);
    }

    private void createEvenCrew(Set<String> crews, int i) {
        crews.add(this.suffledCrew.get(i));
        crews.add(this.suffledCrew.get(i + 1));
        pairs.add(crews);
    }

    public boolean checkDuplication(MissionList missionList, Level level) {
        for (Set<String> stringSet : missionList.getLevelPairs(level)) {
            for (Set<String> missionStringSet : this.getPairs()) {
                return missionStringSet.equals(stringSet);
            }
        }
        return false;
    }


}
