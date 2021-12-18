package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final Mission mission;
    private List<Pair> pairs;

    public Result(Mission mission, List<Pair> pairs) {
        this.mission = mission;
        if (pairs.size() != 0) {
            this.pairs = pairs;
        }
        this.pairs = new ArrayList<>();
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public void checkOneCrew() {
        for (int i = 0; i < pairs.size(); i++) {
            Pair target = pairs.get(i);
            if (target.getCrewsOfPair().size() == 1) {
                Pair pair = pairs.get(i - 1);
                pair.merge(target.getCrewsOfPair().get(0));
                pairs.remove(i);
            }
        }
    }


}
