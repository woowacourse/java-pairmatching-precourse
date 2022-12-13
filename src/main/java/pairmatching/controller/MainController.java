package pairmatching.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pairmatching.controller.subController.ApplicationExitController;
import pairmatching.controller.subController.Controllable;
import pairmatching.controller.subController.CrewLoadingController;
import pairmatching.controller.subController.PairInitializingController;
import pairmatching.controller.subController.PairMatchingController;
import pairmatching.controller.subController.PairSearchingController;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.option.MainOption;
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
        controllers.put(MainOption.PAIR_MATCHING, new PairMatchingController(inputView, outputView));
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

}