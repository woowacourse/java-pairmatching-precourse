package pairmatching.domain.entity;

import java.util.List;

public class Pair {
    private final List<String> crews;

    private Pair(List<String> crews) {
        this.crews = crews;
    }

    public static Pair create(List<String> crews) {
        return new Pair(crews);
    }

    public List<String> getCrews() {
        return crews;
    }
}
