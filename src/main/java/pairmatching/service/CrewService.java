package pairmatching.service;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;
import pairmatching.util.FileIO;

public class CrewService {
    public static List<Crew> getCrews(Course course, Level level, String mission) {
        List<String> crewNames = getCrewNames(course);

        List<Crew> crews = new ArrayList<>();
        for (String name : crewNames) {
            crews.add(Crew.of(course, level, mission, name));
        }
        return crews;
    }

    private static List<String> getCrewNames(Course course){
        if (course == Course.BACKEND) {
            return FileIO.backendCrewNamesFromFile();
        }
        return FileIO.frontendCrewNamesFromFile();
    }
}
