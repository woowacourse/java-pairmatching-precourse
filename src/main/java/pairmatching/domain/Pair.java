package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pair {

    private final List<Crew> crews;

    public Pair() {
        this.crews = new ArrayList<>();
    }

    public void add(Crew crew) {
        crews.add(crew);
    }

    public List<Crew> getCrews() {
        return Collections.unmodifiableList(crews);
    }
}
