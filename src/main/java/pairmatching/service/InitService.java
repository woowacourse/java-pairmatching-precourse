package pairmatching.service;

import pairmatching.domain.CrewRepository;
import pairmatching.domain.MissionRepository;

import java.io.IOException;

public class InitService {

    public void initialize() throws IOException {
        MissionRepository.init();
        CrewRepository.init("백엔드", "src/main/resources/backend-crew.md");
        CrewRepository.init("프론트엔드", "src/main/resources/frontend-crew.md");
    }

}
