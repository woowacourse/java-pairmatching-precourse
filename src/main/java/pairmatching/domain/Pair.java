package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {

    private final List<Crew> crews = new ArrayList<>();

    public Pair(Crew crew1, Crew crew2) {
        this.crews.add(crew1);
        this.crews.add(crew2);
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public void addCrew(Crew crew) {
        crews.add(crew);
    }
}
