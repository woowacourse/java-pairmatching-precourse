package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {

    private final List<Crew> crews;

    public Pair(List<Crew> crews) {
        this.crews = crews;
    }

    public Pair() {
        this.crews = new ArrayList<>();
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public void addCrews(Crew crew) {
        crews.add(crew);
    }
}
