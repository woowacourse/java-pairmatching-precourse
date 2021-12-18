package pairmatching.repository;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.enumeration.Course;
import pairmatching.utils.MyFileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {
    private static List<Crew> crews = new ArrayList<>();

    static {
        MyFileReader.readBackendCrewFile()
                .forEach(name ->crews.add(new Crew(Course.BACKEND, name)));

        MyFileReader.readFrontendCrewFile()
                .forEach(name -> crews.add(new Crew(Course.FRONTEND, name)));
    }

    public static List<Crew> getCrews() {
        return Collections.unmodifiableList(crews);
    }

    public static List<Crew> shuffleCrew(Course course) {
        return Randoms.shuffle(crews.stream()
                .filter(crew -> crew.getCourse() == course)
                .collect(Collectors.toList()));
    }
}
