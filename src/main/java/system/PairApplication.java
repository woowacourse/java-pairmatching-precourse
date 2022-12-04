package system;

import controller.Controller;
import controller.ReadingCrewsFileController;
import repository.CrewRepository;

import java.util.HashMap;
import java.util.Map;

public class PairApplication {
    public static final String READING_CREW_FILE_CONTROLLER_PATH = "readCrewFile";
    private final Map<String, Controller> controllers = new HashMap<>();

    public PairApplication() {
        controllers.put(READING_CREW_FILE_CONTROLLER_PATH, new ReadingCrewsFileController(new CrewRepository()));
    }

    public void run() {
        HashMap<String, Object> model = new HashMap<>();
        readFileAndSaveCrews(model);
    }

    private void readFileAndSaveCrews(HashMap<String, Object> model) {
        controllers.get(READING_CREW_FILE_CONTROLLER_PATH).process(model);
    }
}
