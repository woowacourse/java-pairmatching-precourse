package pairmatching.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Pair {
    private final Set<String> crews;

    public Pair(String... names){
        crews = Arrays.stream(names)
                .collect(Collectors.toSet());
    }

    public Pair(Collection collection){
        crews = new HashSet<>(collection);
    }

    public boolean isContains(String crewName){
        return crews.contains(crewName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        return crews.size() == pair.crews.size()
                && pair.crews.containsAll(crews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crews);
    }
}
