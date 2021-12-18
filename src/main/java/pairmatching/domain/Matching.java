package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Matching {
    Course course;
    Mission mission;
    List<Pair> pairs;

    public Matching(InputDTO input) {
        this.course = input.course;
        this.mission = input.mission;
        pairs = new ArrayList<>();
    }

    public boolean isSame(InputDTO input) {
        return this.course == input.course && this.mission == input.mission;
    }

    public boolean isSamePairs(Pair p) {
        for (Pair pair : pairs) {
            if (pair.isSame(p)) {
                return true;
            }
        }
        return false;
    }

    public void addAllPairs(List<Pair> p) {
        pairs = p;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Pair p : pairs) {
            result.append(p.toString());
            result.append("\n");
        }
        return result.toString();
    }
}
