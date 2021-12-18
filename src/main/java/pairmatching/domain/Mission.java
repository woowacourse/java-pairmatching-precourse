package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import javax.management.MBeanRegistration;
import java.util.*;

public class Mission {
    private final String missonName;
    private final Level missionLevel;
    private List<Crew> crews;
    private List<Set<Crew>> pairs;

    public Mission(String missonName, Level missionLevel, List<Crew> crews) {
        this.missonName = missonName;
        this.missionLevel = missionLevel;
        this.crews = crews;
        this.pairs = new ArrayList<>();
    }

    public void pairMatching() {
        Randoms.shuffle(crews);

    }

    private void findPair() {
        int listLength = this.crews.size();
        for (int i = 0; i < listLength; i += 2) {
            Set<Crew> crews = new HashSet<>();
            if (listLength % 2 != 0 && i + 3 == listLength) {
                createOddCrew(crews, i);
                break;
            }
            createEvenCrew(crews, i);
        }
    }

    private void createOddCrew(Set<Crew> crews, int i) {
        crews.add(this.crews.get(i));
        crews.add(this.crews.get(i+1));
        crews.add(this.crews.get(i+2));
        pairs.add(crews);
    }

    private void createEvenCrew(Set<Crew> crews, int i) {
        crews.add(this.crews.get(i));
        crews.add(this.crews.get(i + 1));
        pairs.add(crews);
    }

    private void checkDuplicatePair() {

    }

}
