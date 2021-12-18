package pairmatching.model;

import java.util.Objects;

public class Pair {
    private Crew crewX;
    private Crew crewY;

    public Pair(Crew crewX, Crew crewY) {
        this.crewX = crewX;
        this.crewY = crewY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return (Objects.equals(crewX, pair.crewX) && Objects.equals(crewY, pair.crewY)) ||
                (Objects.equals(crewX, pair.crewY) && Objects.equals(crewY, pair.crewX));
    }

    @Override
    public int hashCode() {
        return Objects.hash(crewX, crewY);
    }
}
