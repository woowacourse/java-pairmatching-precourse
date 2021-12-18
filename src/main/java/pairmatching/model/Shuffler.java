package pairmatching.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Shuffler {

    private final List<String> crewNames;

    public Shuffler(final List<String> crewNames) {
        this.crewNames = crewNames;
    }

    public List<String> shuffleCrewNames() {
        return Randoms.shuffle(crewNames);
    }

}
