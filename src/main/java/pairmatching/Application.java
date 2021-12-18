package pairmatching;

import static pairmatching.StringConstants.END_FUNCTION;
import static pairmatching.StringConstants.PAIR_MATCHING_FUNCTION_KEY;

import pairmatching.controller.CrewController;
import pairmatching.controller.MissionController;
import pairmatching.domain.crew.CrewRepository;
import pairmatching.domain.mission.MissionRepository;

public class Application {
    private static final CrewRepository crewRepository = new CrewRepository();
    private static final CrewController crewController = new CrewController(crewRepository);
    private static final MissionRepository missionRepository = new MissionRepository();
    private static final MissionController missionController = new MissionController(missionRepository);

    public static void main(String[] args) {
        createCrew();
        createMission();
        String functionKey = InputView.inputFunctionKey();
    }

    private static void createCrew() {
        crewController.createBackendCrew(CrewNameReader.getBackendCrewNames());
        crewController.createFrontEndCrew(CrewNameReader.getFrontendCrewNames());
    }

    private static void createMission() {
        missionRepository.createMissions();
    }

    private static void checkFunction(String functionKey) {
        if(functionKey.equals(END_FUNCTION)) {
            return;
        }
        InputView.inputInfoAboutPairOfFunction();
        callFunction(functionKey);
    }

    private static void callFunction(String functionKey) {
        if(functionKey.equals(PAIR_MATCHING_FUNCTION_KEY)) {
            matchPair();
        }

        if(functionKey.equals(PAIR_MATCHING_FUNCTION_KEY)) {

        }

        if(functionKey.equals(PAIR_MATCHING_FUNCTION_KEY)) {

        }
    }

    private static void matchPair() {

    }

}
