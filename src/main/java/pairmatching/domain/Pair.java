package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pair {

    private static final int DUPLICATION_NUMBER = 1;
    private final List<Crew> crews;

    public Pair() {
        this.crews = new ArrayList<>();
    }

    public void add(Crew crew) {
        crews.add(crew);
    }

    public boolean isCrews(Pair pair) {
        return pair.getCrews().stream()
                .filter(this.crews::contains)
                .count() > DUPLICATION_NUMBER;
    }

    public List<Crew> getCrews() {
        return Collections.unmodifiableList(crews);
    }
}
