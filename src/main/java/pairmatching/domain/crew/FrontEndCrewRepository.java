package pairmatching.domain.crew;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrontEndCrewRepository {
    private static final List<Crew> crews = new ArrayList<>();

    public static List<Crew> crews() {
        return Collections.unmodifiableList(crews);
    }

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

    public static List<Crew> getCrews() {
        return crews;
    }

    public static void deleteAll() {
        crews.clear();
    }
}
