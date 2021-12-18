package pairmatching.domain;

import java.util.*;

public class Crew {
    private static final int MAXIMUM_LEVEL = 1;
    private static final int MINIMUM_LEVEL = 5;
    private final String name;
    private Map<Level, Set<Crew>> matchingHistory;

    public Crew(String name) {
        this.name = name;
        initMatchingHistory();
    }

    private void initMatchingHistory() {
        matchingHistory = new HashMap<>();
        for (Level level : Level.values()) {
            matchingHistory.put(level, new HashSet<>());
        }
    }

    public void addHistory(Crew colleague, Level level) {
        matchingHistory.get(level).add(colleague);
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
        return this.name.equals(other.name) && this.matchingHistory == other.matchingHistory;
    }

    public String getName() {
        return name;
    }

    public Map<Level, Set<Crew>> getMatchingHistory() {
        return matchingHistory;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "name='" + name + '\'' +
                '}';
    }
}
