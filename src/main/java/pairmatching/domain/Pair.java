package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    private List<Crew> crews;

    public Pair(Crew c1, Crew c2) {
        crews = new ArrayList<>();
        addCrew(c1);
        addCrew(c2);
    }

    public boolean isSame(Pair compare) {
        boolean result = true;
        for (Crew c : compare.getCrews()) {
            if (!crews.contains(c)) {
                result = false;
            }
        }
        return result;
    }

    public void addCrew(Crew c) {
        crews.add(c);
    }

    public List<Crew> getCrews() {
        return this.crews;
    }

    @Override
    public String toString() {
        return String.join(" : ", crews.stream().map(c -> c.getName()).collect(Collectors.toList()));
    }
}
