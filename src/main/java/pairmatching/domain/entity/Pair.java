package pairmatching.domain.entity;

import java.util.List;

public class Pair {
    private final List<String> crews;

    public Pair(List<String> crews) {
        this.crews = crews;
    }

    public List<String> getCrews() {
        return crews;
    }
}
