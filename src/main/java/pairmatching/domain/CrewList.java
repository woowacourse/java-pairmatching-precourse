package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.constant.SystemMessage.*;

public class CrewList {
    List<Crew> crewList = new ArrayList<>();

    public void add(String crewName) {
        crewList.add(new Crew(crewName));
    }

    public List<String> shuffle() {
        return Randoms.shuffle(toStringList());
    }

    public boolean isOdd() {
        return crewList.size() % EVEN == 1;
    }

    public boolean isEven() {
        return crewList.size() % EVEN == 0;
    }

    @Override
    public String toString() {
        if (isEven()) {
            return makeToStringByEven();
        }
        return makeToStringByOdd();
    }

    private List<String> toStringList() {
        List<String> crewListString = new ArrayList<>();
        for (Crew crew : crewList) {
            crewListString.add(crew.toString());
        }
        return crewListString;
    }

    private String makeToStringByEven() {
        StringBuilder matchedCrew = new StringBuilder();
        List<String> crewListString = toStringList();
        for (int i = 0; i < crewList.size(); i = i + EVEN) {
            matchedCrew.append(String.join(DELIMITER, crewListString.subList(i, i + EVEN)));
            matchedCrew.append(NEW_LINE);
        }
        return matchedCrew.toString();
    }

    private String makeToStringByOdd() {
        StringBuilder matchedCrew = new StringBuilder();
        List<String> crewListString = toStringList();
        for (int i = 0; i < crewList.size() - ODD_THREE; i = i + EVEN) {
            matchedCrew.append(String.join(DELIMITER, crewListString.subList(i, i + EVEN)));
            matchedCrew.append(NEW_LINE);
        }
        matchedCrew.append(String.join(DELIMITER, crewListString.subList(crewList.size() - ODD_THREE, crewList.size())));
        return matchedCrew.toString();
    }
}
