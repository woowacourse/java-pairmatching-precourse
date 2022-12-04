package pairmatching.model;

import java.util.Collections;
import java.util.List;

public class Pair {
    private final List<String> crews;

    public Pair(List<String> crews) {
        this.crews = crews;
    }

    public List<String> getCrewNames() {
        return Collections.unmodifiableList(crews);
    }
}
