package pairmatching.controller;

import pairmatching.domain.crew.BackEndCrewRepository;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.CrewReader;

public class MainController {
    private void initializeCrews() {
        initializeBackEndCrews();
        initializeFrontEndCrews();
    }

    private void initializeBackEndCrews() {
        CrewReader reader = new CrewReader();
        for (Crew crew : reader.readBECrewFromMd()) {
            BackEndCrewRepository.addCrew(crew);
        }
    }

    private void initializeFrontEndCrews() {
        CrewReader reader = new CrewReader();
        for (Crew crew : reader.readFECrewFromMd()) {
            BackEndCrewRepository.addCrew(crew);
        }
    }
}
