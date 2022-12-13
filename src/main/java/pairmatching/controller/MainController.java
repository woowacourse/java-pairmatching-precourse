package pairmatching.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import pairmatching.domain.ApplicationStatus;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<ApplicationStatus, Runnable> controllers;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controllers = new EnumMap<>(ApplicationStatus.class);
        initializeControllers();
    }

    private void initializeControllers() {
        controllers.put(ApplicationStatus.CREW_LOADING, this::crewLoading);
        controllers.put(ApplicationStatus.PAIR_MATCHING, this::pairMatching);
        controllers.put(ApplicationStatus.PAIR_SEARCHING, this::pairSearching);
        controllers.put(ApplicationStatus.PAIR_INITIALIZING, this::pairInitializing);
        controllers.put(ApplicationStatus.APPLICATION_EXIT, this::exitApplication);
    }

    public void service() {
        progress(ApplicationStatus.CREW_LOADING);
    }

    public void progress(ApplicationStatus applicationStatus) {
        try {
            controllers.get(applicationStatus).run();
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