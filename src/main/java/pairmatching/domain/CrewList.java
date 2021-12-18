package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.constant.SystemMessage.*;

public class CrewList {
    List<Crew> crewList = new ArrayList<>();

    public void add(String crewName) {
        crewList.add(new Crew(crewName));
    }

    public List<String> shuffle() {
        return Randoms.shuffle(toStringList());
    }

    public void initCrewListBy(List<String> stringList) {
        List<Crew> newCrewList = new ArrayList<>();
        for (String str : stringList) {
            newCrewList.add(new Crew(str));
        }
        crewList = newCrewList;
    }

    public boolean isMatched(Level level) {
        for (int i = 0; i < crewList.size() - EVEN; i = i + EVEN) {
            Crew crew = crewList.get(i);
            if (crew.isMatched(level, crewList.get(i + 1))) {
                return false;
            }
        }
        if (!isEven()) {
            return checkAdditional(level);
        }
        return true;
    }

    private boolean checkAdditional(Level level) {
        Crew lastFirstCrew = crewList.get(crewList.size() - FIRST);
        Crew lastSecondCrew = crewList.get(crewList.size() - SECOND);
        Crew lastThirdCrew = crewList.get(crewList.size() - THIRD);
        if (lastFirstCrew.isMatched(level, lastSecondCrew)) {
            return false;
        }
        if (lastFirstCrew.isMatched(level, lastThirdCrew)) {
            return false;
        }
        return true;
    }

    public void addPartner(Level level) {
        for (int i = 0; i < crewList.size() - EVEN; i = i + EVEN) {
            Crew crew = crewList.get(i);
            Crew crewPartner = crewList.get(i + 1);
            crew.addMatchedPartner(level, crewPartner);
            crewPartner.addMatchedPartner(level, crew);
        }
        if (!isEven()) {
            addPartnerAdditional(level);
        }
    }

    private void addPartnerAdditional(Level level) {
        Crew lastFirstCrew = crewList.get(crewList.size() - FIRST);
        Crew lastSecondCrew = crewList.get(crewList.size() - SECOND);
        Crew lastThirdCrew = crewList.get(crewList.size() - THIRD);
        lastFirstCrew.addMatchedPartner(level, lastSecondCrew);
        lastFirstCrew.addMatchedPartner(level, lastThirdCrew);
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
            matchedCrew.append(String.join(MATCHING_JOIN_DELIMITER, crewListString.subList(i, i + EVEN)));
            matchedCrew.append(NEW_LINE);
        }
        return matchedCrew.toString();
    }

    private String makeToStringByOdd() {
        StringBuilder matchedCrew = new StringBuilder();
        List<String> crewListString = toStringList();
        for (int i = 0; i < crewList.size() - ODD_THREE; i = i + EVEN) {
            matchedCrew.append(String.join(MATCHING_JOIN_DELIMITER, crewListString.subList(i, i + EVEN)));
            matchedCrew.append(NEW_LINE);
        }
        matchedCrew.append(String.join(MATCHING_JOIN_DELIMITER, crewListString.subList(crewList.size() - ODD_THREE, crewList.size())));
        return matchedCrew.toString();
    }
}