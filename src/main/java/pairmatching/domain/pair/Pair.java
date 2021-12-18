package pairmatching.domain.pair;

import pairmatching.domain.Crew;
import pairmatching.domain.Level;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private final Level level;
    private final List<Crew> crews = new ArrayList<>();

    public Pair(Level level) {
        this.level = level;
    }

    public void addCrew(Crew crew) {
        crews.add(crew);
    }

    public boolean hasCrew(Crew crew) {
        return crews.contains(crew);
    }

    public List<Crew> getCrews() {
        return crews;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "level=" + level +
                ", crews=" + crews +
                '}';
    }

    public boolean hasThreeCrewMembers() {
        return crews.size() == 3;
    }
}
