package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {

    private static final List<Crew> crews = new ArrayList<>();

    public static List<Crew> getCrews() { return crews; }

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }
}
