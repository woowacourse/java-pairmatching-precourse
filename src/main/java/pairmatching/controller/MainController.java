package pairmatching.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.MainOption;
import pairmatching.domain.repository.Crews;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<MainOption, Runnable> controllers;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controllers = new EnumMap<>(MainOption.class);
        initializeControllers();
    }

    private void initializeControllers() {
        controllers.put(MainOption.PAIR_MATCHING, this::pairMatching);
        controllers.put(MainOption.PAIR_SEARCHING, this::pairSearching);
        controllers.put(MainOption.PAIR_INITIALIZING, this::pairInitializing);
        controllers.put(MainOption.APPLICATION_EXIT, this::exitApplication);
    }

    public void service() {
        crewLoading();
        MainOption mainOption;
        do {
            mainOption = inputView.readMainOption();
            progress(mainOption);
        } while (mainOption.isPlayable());
    }

    public void progress(MainOption mainOption) {
        try {
            controllers.get(mainOption).run();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void crewLoading() {
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

    private void pairMatching() {

    }

    private void pairSearching() {
    }

    private void pairInitializing() {

    }

    private void exitApplication() {

    }

}