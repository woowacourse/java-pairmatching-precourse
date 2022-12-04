package system;

import controller.Controller;
import controller.ReadingCrewsFileController;
import controller.SavingMissionsController;
import repository.CrewRepository;
import repository.MissionRepository;

import java.util.HashMap;
import java.util.Map;

public class PairApplication {
    public static final String READING_CREW_FILE_CONTROLLER_PATH = "readCrewFile";
    public static final String SAVE_MISSIONS_CONTROLLER_PATH = "saveMissions";
    private final Map<String, Controller> controllers = new HashMap<>();

    public PairApplication() {
        controllers.put(READING_CREW_FILE_CONTROLLER_PATH, new ReadingCrewsFileController(new CrewRepository()));
        controllers.put(SAVE_MISSIONS_CONTROLLER_PATH, new SavingMissionsController(new MissionRepository()));
    }

    public void run() {
        HashMap<String, Object> model = new HashMap<>();
        readFileAndSaveCrews(model);
    }

    private void readFileAndSaveCrews(HashMap<String, Object> model) {
        controllers.get(READING_CREW_FILE_CONTROLLER_PATH).process(model);
        controllers.get(SAVE_MISSIONS_CONTROLLER_PATH).process(model);
    }
}
