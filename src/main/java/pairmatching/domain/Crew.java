package pairmatching.domain;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class Crew {
    private final String name;
    private Map<Level, Set<Crew>> memoriesWithCrewByLevel;

    public Crew(String name) {
        this.name = name;
        initMatchingHistory();
    }

    private void initMatchingHistory() {
        memoriesWithCrewByLevel = new HashMap<>();
        for (Level level : Level.values()) {
            memoriesWithCrewByLevel.put(level, new HashSet<>());
        }
    }

    public void addHistory(Crew colleague, Level level) {
        memoriesWithCrewByLevel.get(level).add(colleague);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Crew other = (Crew) object;
        return this.name.equals(other.name) && this.memoriesWithCrewByLevel == other.memoriesWithCrewByLevel;
    }

    public boolean isContainCrew(Level level, Crew colleague) {
        return this.memoriesWithCrewByLevel.get(level).contains(colleague);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
