package pairmatching;

import pairmatching.controller.CrewController;
import pairmatching.crewService.CrewRepository;

public class Application {
    private static final CrewRepository crewRepository = new CrewRepository();
    private static final CrewController crewController = new CrewController(crewRepository);

    public static void main(String[] args) {
        createCrew();
        InputView.inputFunctionKey();
    }

    private static void createCrew() {
        crewController.createBackendCrew(CrewNameReader.getBackendCrewNames());
        crewController.createFrontEndCrew(CrewNameReader.getFrontendCrewNames());
    }
}
