package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private List<String> crews;

    public Pair(String one, String two) {
        this.crews = new ArrayList<>();
        crews.add(one);
        crews.add(two);
    }

    public List<String> getCrews() {
        return crews;
    }

    public void addCrew(String crew) {
        this.crews.add(crew);
    }
}
