package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private List<String> crews;

    public Pair(String firstCrew, String secondCrew) {
        crews = new ArrayList<>();
        crews.add(firstCrew);
        crews.add(secondCrew);
    }

    public void addCrew(String crew) {
        crews.add(crew);
    }

    public List<String> getCrews() {
        return new ArrayList<>(crews);
    }
}
