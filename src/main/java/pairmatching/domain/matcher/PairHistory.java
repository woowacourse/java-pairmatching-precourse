package pairmatching.domain.matcher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import pairmatching.domain.ErrorMessage;
import pairmatching.domain.crew.Crew;

public class PairHistory {
    private HashMap<String, Integer> crewsIndex = new HashMap<>();
    private Boolean[][] history;

    public PairHistory(List<Crew> crewList) {
        initCrewIndex(crewList);
        initHistory(crewList.size());
    }

    public boolean isCrewAndCrewMeet(Crew crew1, Crew crew2) {
        return history[getIndexOfCrew(crew1)][getIndexOfCrew(crew2)] ||
            history[getIndexOfCrew(crew2)][getIndexOfCrew(crew1)];
    }

    public void setCrewAndCrewMet(Crew crew1, Crew crew2) {
        if (!isCrewAndCrewMeet(crew1, crew2))
            history[getIndexOfCrew(crew1)][getIndexOfCrew(crew2)] = true;
        history[getIndexOfCrew(crew2)][getIndexOfCrew(crew1)] = true;
    }

    private void initCrewIndex(List<Crew> crewList) {
        int index = 0;
        for (Crew crew : crewList) {
            crewsIndex.put(crew.getName(), index++);
        }
    }

    private void initHistory(int size) {
        history = new Boolean[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(history[i], false);
        }
    }

    private int getIndexOfCrew(Crew crew) {
        checkCrewExist(crew);
        return crewsIndex.get(crew.getName());
    }

    private void checkCrewExist(Crew crew) {
        if (!crewsIndex.containsKey(crew.getName())) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage("존재 하지 않느 크루입니다."));
        }
    }
}
