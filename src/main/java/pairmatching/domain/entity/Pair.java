package pairmatching.domain.entity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Pair {
    private final List<String> crews;

    private Pair(List<String> crews) {
        Collections.sort(crews);
        this.crews = crews;
    }

    public static Pair create(List<String> crews) {
        return new Pair(crews);
    }

    public List<String> getCrews() {
        return crews;
    }

    public void addCrew(String crew) {
        crews.add(crew);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Pair otherPair = (Pair) other;

        return otherPair.getCrews().equals(crews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crews);
    }
}
