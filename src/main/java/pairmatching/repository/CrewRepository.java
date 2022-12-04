package pairmatching.repository;

import pairmatching.model.Crew;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    private final List<Crew> crews = new ArrayList<>();

    public void saveAll(List<Crew> crews) {
        this.crews.addAll(crews);
    }
}
