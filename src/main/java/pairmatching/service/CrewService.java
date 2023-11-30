package pairmatching.service;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;
import pairmatching.util.FileIO;

public class CrewService {
    public static List<Crew> getCrews(Course course, Level level, String mission) {
        List<String> crewNames;
        if (course == Course.BACKEND) {
            crewNames = FileIO.backendCrewNamesFromFile();
        } else {
            crewNames = FileIO.frontendCrewNamesFromFile();
        }

        List<Crew> crews = new ArrayList<>();
        for (String name : crewNames) {
            crews.add(Crew.of(course, level, mission, name));
        }
        return crews;
    }
}
