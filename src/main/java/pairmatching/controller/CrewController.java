package pairmatching.controller;

import java.util.List;

import pairmatching.crewService.CrewRepository;
import pairmatching.domain.Course;

public class CrewController {
    private final CrewRepository crewRepository;

    public CrewController(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    public void createBackendCrew(List<String> crewNames) {
        crewRepository.createCrew(crewNames, Course.BACKEND);
    }

    public void createFrontEndCrew(List<String> crewNames) {
        crewRepository.createCrew(crewNames, Course.FRONTEND);
    }
}
