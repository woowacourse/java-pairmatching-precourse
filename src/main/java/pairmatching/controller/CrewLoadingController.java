package pairmatching.controller;

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

    private final InputView inputView;
    private final OutputView outputView;

    public CrewLoadingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        try {
            File backendCrews = new File("src/main/resources/backend-crew.md");
            BufferedReader backendCrewsReader = new BufferedReader(new FileReader(backendCrews));
            String backendCrew;
            while ((backendCrew = backendCrewsReader.readLine()) != null) {
                Crews.addCrew(new Crew(Course.BACKEND, backendCrew));
            }

            File frontendCrews = new File("src/main/resources/frontend-crew.md");
            BufferedReader frontendCrewsReader = new BufferedReader(new FileReader(frontendCrews));
            String frontendCrew;
            while ((frontendCrew = frontendCrewsReader.readLine()) != null) {
                Crews.addCrew(new Crew(Course.FRONTEND, frontendCrew));
            }

        } catch (IOException exception) {
            outputView.printExceptionMessage(exception);
            throw new RuntimeException(exception);
        }
    }
}
