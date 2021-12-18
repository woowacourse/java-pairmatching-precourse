package pairmatching.domain;

import pairmatching.utils.ConstantMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pair {
    private List<Crew> crews = new ArrayList<>();

    public void addCrew(Crew crew) {
        crews.add(crew);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(crews, pair.crews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crews);
    }

    @Override
    public String toString() {
        return String.join(ConstantMessages.CREW_DELIMITER, crews.stream()
                .map(crew -> crew.getName())
                .collect(Collectors.toList()));
    }
}
