package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import javax.management.MBeanRegistration;
import java.util.*;

public class Mission {
    private final String missonName;
    private final Level missionLevel;
    private List<String> crews;
    private List<Set<String>> pairs;

    public Mission(String missonName, Level missionLevel, List<String> crews) {
        this.missonName = missonName;
        this.missionLevel = missionLevel;
        this.crews = crews;
        this.pairs = new ArrayList<>();
    }

    public void pairMatching() {
        List<String> suffledCrew = Randoms.shuffle(crews);
    }

    public boolean checkMatchingHistory() {
        if (pairs.isEmpty()) {
            return false;
        }
        return true;
    }

    private void findPair() {
        int listLength = this.crews.size();
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
        crews.add(this.crews.get(i));
        crews.add(this.crews.get(i+1));
        crews.add(this.crews.get(i+2));
        pairs.add(crews);
    }

    private void createEvenCrew(Set<String> crews, int i) {
        crews.add(this.crews.get(i));
        crews.add(this.crews.get(i + 1));
        pairs.add(crews);
    }


}
