package pairmatching.system.convertion;

import pairmatching.model.Course;
import pairmatching.model.Crew;

import java.util.List;
import java.util.stream.Collectors;

public class NamesToCrewConverter {

    public static List<Crew> convert(List<String> crewNames, Course course) {
        // TODO: 변환 검증 필요하다
        return crewNames.stream()
                .map(crewName -> new Crew(course, crewName))
                .collect(Collectors.toList());
    }
}
