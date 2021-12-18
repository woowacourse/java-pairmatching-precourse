package pairmatching.utils;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.crew.Crew;
import pairmatching.crew.Position;

public class CrewListInitializer {

    public static List<Crew> getBackendCrews() {
        return CrewReader.readBackendCrews().stream()
            .map(name -> new Crew(name, Position.BACKEND))
            .collect(Collectors.toList());
    }

    public static List<Crew> getFrontEndCrews() {
        return CrewReader.readBackendCrews().stream()
            .map(name -> new Crew(name, Position.FRONTEND))
            .collect(Collectors.toList());
    }
}
