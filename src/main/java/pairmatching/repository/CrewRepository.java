package pairmatching.repository;

import pairmatching.domain.Crew;
import pairmatching.view.Message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    private static final List<Crew> crews = new ArrayList<>();

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

    public static Crew findByName(String name) {
        return crews.stream()
                .filter(crew -> crew.isEqual(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.NO_MEMBER));
    }
}
