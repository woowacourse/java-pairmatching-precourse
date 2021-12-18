package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.constant.SystemMessage.*;

public class CrewList {
    List<String> crewList = new ArrayList<>();

    public void add(String crewName) {
        crewList.add(crewName);
    }

    public List<String> shuffle() {
        return Randoms.shuffle(crewList);
    }

    public boolean isOdd() {
        return crewList.size() % EVEN == 1;
    }

    public boolean isEven() {
        return crewList.size() % EVEN == 0;
    }

    @Override
    public String toString() {
        StringBuilder matchedCrew = new StringBuilder();
        if (isEven()) {
            for (int i = 0; i < crewList.size(); i = i + EVEN) {
                matchedCrew.append(String.join(DELIMITER, crewList.subList(i, i + EVEN)));
                matchedCrew.append(NEW_LINE);
            }
            return matchedCrew.toString();
        }
        for (int i = 0; i < crewList.size() - ODD_THREE; i = i + EVEN) {
            matchedCrew.append(String.join(DELIMITER, crewList.subList(i, i + EVEN)));
            matchedCrew.append(NEW_LINE);
        }
        matchedCrew.append(String.join(DELIMITER, crewList.subList(crewList.size() - ODD_THREE, crewList.size())));
        return matchedCrew.toString();
    }
}
