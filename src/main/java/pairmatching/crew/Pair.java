package pairmatching.crew;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private List<Crew> crews;

    private Pair(Crew crew1, Crew crew2) {
        crews = new ArrayList<>();
        crews.add(crew1);
        crews.add(crew2);
    }

    public static Pair createPair(Crew crew1, Crew crew2) {
        return new Pair(crew1, crew2);
    }

    public void addCrew(Crew crew) {
        if (crews != null) {
            crews.add(crew);
        }
    }

    public List<Crew> getCrews() {
        return crews;
    }
}
