package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Crews {

    private Crews() {
    }

    private static final List<Crew> crews = new ArrayList<>();

    public static List<Crew> crews() {
        return Collections.unmodifiableList(crews);
    }

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

    public static boolean deleteCrewByName(String name) {
        return crews.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        crews.clear();
    }

    public static Crew findCrewByName(String name) {
        return crews.stream()
                .filter(crew -> crew.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

}
