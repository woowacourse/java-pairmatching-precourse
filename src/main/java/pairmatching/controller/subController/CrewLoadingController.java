package pairmatching.controller.subController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.repository.Crews;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class CrewLoadingController implements Controllable {

    public static final String BACKEND_CREW_PATH = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_CREW_PATH = "src/main/resources/frontend-crew.md";
    private final InputView inputView;
    private final OutputView outputView;

    public CrewLoadingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        try {
            readBackendCrews(BACKEND_CREW_PATH, Course.BACKEND);
            readBackendCrews(FRONTEND_CREW_PATH, Course.FRONTEND);
        } catch (IOException exception) {
            outputView.printExceptionMessage(exception);
            throw new RuntimeException(exception);
        }
    }

    private static void readBackendCrews(String pathname, Course backend) throws IOException {
        File backendCrews = new File(pathname);
        BufferedReader backendCrewsReader = new BufferedReader(new FileReader(backendCrews));
        String backendCrew;
        while ((backendCrew = backendCrewsReader.readLine()) != null) {
            Crews.addCrew(new Crew(backend, backendCrew));
        }
    }
}
