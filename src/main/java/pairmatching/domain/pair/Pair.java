package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.crew.Crew;

public class Pair {
    private List<Crew> crews = new ArrayList<>();

    public Pair() {
    }

    public Pair(List<String> shuffledCrews) {
    }

    public void addCrew(String crew) {
        crews.add(new Crew(crew));
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
