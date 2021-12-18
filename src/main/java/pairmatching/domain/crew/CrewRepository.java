package pairmatching.domain.crew;

import java.util.*;

import pairmatching.domain.Course;
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

    public List<String> getCrewNamesByCourse(Course course) {
        if (course == Course.BACKEND) {
            return new ArrayList<>(backendCrew.keySet());
        }

        if (course == Course.FRONTEND) {
            return new ArrayList<>(frontendCrew.keySet());
        }
        return null;
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

