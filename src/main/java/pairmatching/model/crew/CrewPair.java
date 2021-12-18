package pairmatching.model.crew;

import java.util.Objects;

public class CrewPair {
    private final Crew firstCrew;
    private final Crew secondCrew;

    public CrewPair(final Crew firstCrew, final Crew secondCrew) {
        this.firstCrew = firstCrew;
        this.secondCrew = secondCrew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrewPair crewPair = (CrewPair) o;
        return (Objects.equals(firstCrew, crewPair.firstCrew) && Objects.equals(secondCrew, crewPair.secondCrew))
                || (Objects.equals(firstCrew, crewPair.secondCrew) && Objects.equals(secondCrew, crewPair.firstCrew));
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstCrew, secondCrew);
    }
}
