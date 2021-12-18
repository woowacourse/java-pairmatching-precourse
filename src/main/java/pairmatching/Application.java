package pairmatching;

import static pairmatching.StringConstants.END_FUNCTION_KEY;
import static pairmatching.StringConstants.PAIR_MATCHING_FUNCTION_KEY;

import pairmatching.controller.CrewController;
import pairmatching.controller.MissionController;
import pairmatching.controller.PairController;
import pairmatching.domain.Course;
import pairmatching.domain.PairRepository;
import pairmatching.domain.crew.CrewRepository;
import pairmatching.domain.mission.MissionRepository;
import pairmatching.service.PairService;

public class Application {
    private static final CrewRepository crewRepository = new CrewRepository();
    private static final CrewController crewController = new CrewController(crewRepository);
    private static final MissionRepository missionRepository = new MissionRepository();
    private static final MissionController missionController = new MissionController(missionRepository);
    private static final PairRepository pairRepository = new PairRepository();
    private static final PairService pairService = new PairService(pairRepository, crewRepository, missionRepository);
    private static final PairController pairController = new PairController(pairService);

    public static void main(String[] args) {
        createCrew();
        createMission();
        checkFunction(InputView.inputFunctionKey());
    }

    private static void createCrew() {
        crewController.createBackendCrew(CrewNameReader.getBackendCrewNames());
        crewController.createFrontEndCrew(CrewNameReader.getFrontendCrewNames());
    }

    private static void createMission() {
        missionController.createMissions();
    }

    private static void checkFunction(String functionKey) {
        if (functionKey.equals(END_FUNCTION_KEY)) {
            return;
        }
        String[] pairInfoToPerformFunction = InputView.inputPairInfoToPerformFunction(missionController.findAllMissionNames(), missionController.findMissionNamesByLevel());
        callFunction(functionKey, pairInfoToPerformFunction);
    }

    private static void callFunction(String functionKey, String[] pairInfoToPerformFunction) {
        if (functionKey.equals(PAIR_MATCHING_FUNCTION_KEY)) {
            matchPairs(pairInfoToPerformFunction);
        }

        if (functionKey.equals(PAIR_MATCHING_FUNCTION_KEY)) {

        }

        if (functionKey.equals(PAIR_MATCHING_FUNCTION_KEY)) {

        }
    }

    private static void matchPairs(String[] pairInfoToPerformFunction) {
        pairController.createPairs(pairInfoToPerformFunction);
    }

}
