package pairmatching.model.crew;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewPair {
    private final List<Crew> crews = new ArrayList<>();

    public CrewPair(final Crew firstCrew, final Crew secondCrew) {
        crews.add(firstCrew);
        crews.add(secondCrew);
    }

    public CrewPair(final Crew firstCrew, final Crew secondCrew, final Crew thirdCrew) {
        crews.add(firstCrew);
        crews.add(secondCrew);
        crews.add(thirdCrew);
    }

    public List<String> getNames() {
        return crews.stream().map(Crew::getName).collect(Collectors.toList());
    }

    public boolean isSameCaseWith(CrewPair anotherPair) {
        int sameCount = anotherPair.crews.stream()
                .mapToInt(this::getSameCount)
                .sum();
        return sameCount == 2;
    }

    private int getSameCount(Crew another) {
        return (int) crews.stream().filter(crew -> crew.equals(another)).count();
    }
}
