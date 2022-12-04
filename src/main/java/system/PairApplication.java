package system;

import controller.Controller;
import controller.ReadingCrewsFileController;
import controller.SavingMissionsController;
import controller.SelectingFeatureController;
import inputview.GettingFeatureCommandInputView;
import outputview.SelectingFeatureOutputView;
import repository.CrewRepository;
import repository.MissionRepository;

import java.util.HashMap;
import java.util.Map;

public class PairApplication {
    public static final String READING_CREW_FILE_CONTROLLER_PATH = "readCrewFile";
    public static final String SAVE_MISSIONS_CONTROLLER_PATH = "saveMissions";
    public static final String SELECT_FEATURE_CONTROLLER_PATH = "selectFeature";
    private final Map<String, Controller> controllers = new HashMap<>();

    public PairApplication() {
        controllers.put(READING_CREW_FILE_CONTROLLER_PATH, new ReadingCrewsFileController(new CrewRepository()));
        controllers.put(SAVE_MISSIONS_CONTROLLER_PATH, new SavingMissionsController(new MissionRepository()));
        controllers.put(SELECT_FEATURE_CONTROLLER_PATH, new SelectingFeatureController(
                        new SelectingFeatureOutputView(),
                        new GettingFeatureCommandInputView()
                )
        );
    }

    public void run() {
        HashMap<String, Object> model = new HashMap<>();
        readFileAndSaveCrews(model);
    }

    private void readFileAndSaveCrews(HashMap<String, Object> model) {
        controllers.get(READING_CREW_FILE_CONTROLLER_PATH).process(model);
        controllers.get(SAVE_MISSIONS_CONTROLLER_PATH).process(model);
        controllers.get(SELECT_FEATURE_CONTROLLER_PATH).process(model);
    }
}
