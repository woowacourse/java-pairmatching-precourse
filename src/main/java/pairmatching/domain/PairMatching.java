package pairmatching.domain;

import java.util.List;

public class PairMatching {

    private Crews crews;

    public PairMatching() {
        crews = new Crews();
    }

    public List<String> matching(String value) {
        String[] values = value.split(", ");
        List<String> crewNames = crews.matching(values[0]);
        return crewNames;
    }
}
