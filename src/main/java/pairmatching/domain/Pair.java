package pairmatching.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Pair {
    private final Set<String> crews;

    public Pair(String... names){
        crews = Arrays.stream(names)
                .collect(Collectors.toSet());
    }

    public boolean isContains(String crewName){
        return crews.contains(crewName);
    }
}
