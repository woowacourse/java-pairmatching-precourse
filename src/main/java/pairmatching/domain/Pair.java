package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Pair {
    private final List<String> crews;

    public Pair(String... names){
        crews = Arrays.stream(names)
                .toList();
    }

    public Pair(Collection collection){
        crews = new ArrayList<>(collection);
    }

    public List<String> getCrews() {
        return crews;
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

    @Override
    public String toString() {
        return "Pair{" +
                "crews=" + String.join(" : ", crews.stream()
                .toList()) +
                '}';
    }
}
