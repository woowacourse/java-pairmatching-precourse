package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.crew.Crew;

public class Pair {
    private List<Crew> crews = new ArrayList<>();

    public Pair() {
    }

    public void addCrew(String crew) {
        crews.add(new Crew(crew));
    }

    public void add(String shuffledCrew) {
        crews.add(new Crew(shuffledCrew));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String result = crews.stream().map(Crew::getName)
            .collect(Collectors.joining(" : "));
        stringBuilder.append(result);
        return stringBuilder.toString();
    }
}
