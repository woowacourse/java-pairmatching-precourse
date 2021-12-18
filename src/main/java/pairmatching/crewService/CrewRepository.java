package pairmatching.crewService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class CrewRepository {
    private final Map<String, Crew> backendCrew = new HashMap<>();
    private final Map<String, Crew> frontendCrew = new HashMap<>();

    public void createCrew(List<String> crewNames, Course course) {
        if(course == Course.BACKEND) {
            createBackendCrew(crewNames);
        }

        if(course == Course.FRONTEND) {
            createFrontendCrew(crewNames);
        }
    }

    private void createBackendCrew(List<String> crewNames) {
        for (String crewName : crewNames) {
            Crew crew = new Crew(Course.BACKEND, crewName);
            backendCrew.put(crewName, crew);
        }
    }

    private void createFrontendCrew(List<String> crewNames) {
        for (String crewName : crewNames) {
            Crew crew = new Crew(Course.FRONTEND, crewName);
            frontendCrew.put(crewName, crew);
        }
    }
}
