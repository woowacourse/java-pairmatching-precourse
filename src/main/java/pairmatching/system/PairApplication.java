package pairmatching.system;

import pairmatching.controller.*;
import pairmatching.inputview.GettingFeatureCommandInputView;
import pairmatching.inputview.SelectingMissionInputView;
import pairmatching.outputview.MatchingResultOutputView;
import pairmatching.outputview.SelectingFeatureOutputView;
import pairmatching.outputview.SelectingMissionOutputView;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.system.util.PairsMaker;
import pairmatching.vo.FeatureCommand;

import java.util.HashMap;
import java.util.Map;

public class PairApplication {
    public static final String READING_CREW_FILE_CONTROLLER_PATH = "readCrewFile";
    public static final String SAVE_MISSIONS_CONTROLLER_PATH = "saveMissions";
    public static final String SELECT_FEATURE_CONTROLLER_PATH = "selectFeature";
    public static final String SELECTING_MISSION_PATH = "selectMission";
    public static final String MATCHING_PAIR = "matchPair";
    private final Map<String, Controller> controllers = new HashMap<>();

    public PairApplication() {
        MissionRepository missionRepository = new MissionRepository();
        CrewRepository crewRepository = new CrewRepository();

        controllers.put(READING_CREW_FILE_CONTROLLER_PATH, new ReadingCrewsFileController(crewRepository));
        controllers.put(SAVE_MISSIONS_CONTROLLER_PATH, new SavingMissionsController(missionRepository));
        controllers.put(SELECT_FEATURE_CONTROLLER_PATH, new SelectingFeatureController(
                new SelectingFeatureOutputView(),
                new GettingFeatureCommandInputView()
        ));
        controllers.put(SELECTING_MISSION_PATH, new SelectingMissionController(
                new SelectingMissionOutputView(),
                new SelectingMissionInputView(),
                missionRepository
        ));
        controllers.put(MATCHING_PAIR, new MatchingPairController(
                crewRepository,
                new PairMatchingRepository(),
                new PairsMaker(),
                new MatchingResultOutputView())
        );
    }

    public void run() {
        HashMap<String, Object> model = new HashMap<>();
        readFileAndSaveCrews(model);
        saveMissions(model);
        getFeatureCommand(model);

        doFeature(model);
    }

    private void doFeature(HashMap<String, Object> model) {
        FeatureCommand featureCommand = (FeatureCommand) model.get("featureCommand");
        if (featureCommand == FeatureCommand.MATCHING) {
            controllers.get(SELECTING_MISSION_PATH).process(model);
            controllers.get(MATCHING_PAIR).process(model);
        }
        if (featureCommand == FeatureCommand.FIND) {

        }
        if (featureCommand == FeatureCommand.RESET) {

        }
        if (featureCommand == FeatureCommand.QUIT) {

        }
    }

    private void getFeatureCommand(HashMap<String, Object> model) {
        controllers.get(SELECT_FEATURE_CONTROLLER_PATH).process(model);
    }

    private void saveMissions(HashMap<String, Object> model) {
        controllers.get(SAVE_MISSIONS_CONTROLLER_PATH).process(model);
    }

    private void readFileAndSaveCrews(HashMap<String, Object> model) {
        controllers.get(READING_CREW_FILE_CONTROLLER_PATH).process(model);
    }
}
