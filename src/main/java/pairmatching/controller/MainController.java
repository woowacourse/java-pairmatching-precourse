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
    private final Map<MainOption, Controllable> controllers;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controllers = new EnumMap<>(MainOption.class);
        initializeControllers();
    }

    private void initializeControllers() {
        controllers.put(MainOption.PAIR_MATCHING, new PairMatchingController());
        controllers.put(MainOption.PAIR_SEARCHING, new PairSearchingController());
        controllers.put(MainOption.PAIR_INITIALIZING, new PairInitializingController());
        controllers.put(MainOption.APPLICATION_EXIT, new ApplicationExitController());
    }

    public void service() {
       new CrewLoadingController(inputView, outputView).process();
        MainOption mainOption;
        do {
            mainOption = inputView.readMainOption();
            progress(mainOption);
        } while (mainOption.isPlayable());
    }

    public void progress(MainOption mainOption) {
        try {
            controllers.get(mainOption).process();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }


    private void pairMatching() {
        String option = inputView.readPairingOption();
    }

    private void pairSearching() {
    }

    private void pairInitializing() {

    }

    private void exitApplication() {

    }

}