package pairmatching.controller;

import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.domain.enumeration.MainFeature;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {

    public void run() {
        while (true){
            MainFeature mainFeature = selectMainFeature();
            if(mainFeature == MainFeature.PAIR_RESET) {
                mainFeature.apply(defaultArr());
                continue;
            }
            if(mainFeature != MainFeature.QUIT) {
                OutputView.printSelectMenu();
                OutputView.printResult(runMainFeature(mainFeature));
            }
        }

    }

    private Pairs runMainFeature(MainFeature mainFeature) {
        Pairs pairs = null;
        String input = null;
        try {
            input = InputView.insertCourseLevelMission();
            pairs = mainFeature.apply(PairService.validateInput(input));
            if(pairs == null) {
                return runMainFeature(mainFeature);
            }
        }catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return runMainFeature(mainFeature);
        }
        return pairs;
    }

    private MainFeature selectMainFeature() {
        String input = InputView.insertMainFunction();
        MainFeature mainFeature = null;
        try {
            mainFeature = MainFeature.findFeatureByInput(input);
        }catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return selectMainFeature();
        }
        return mainFeature;
    }

    private String[] defaultArr() {
        return null;
    }
}
