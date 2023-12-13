package pairmatching.controller;

import java.util.List;
import pairmatching.domain.MatchingConditions;
import pairmatching.domain.constant.OptionCommand;
import pairmatching.domain.Pairs;
import pairmatching.domain.constant.RematchingCommand;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MatchingService matchingService;

    public MatchingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.matchingService = new MatchingService();
    }

    public void run() {
        start();
    }

    private void start() {
        while (true) {
            String option = readOption();
            if (option.equals(OptionCommand.MATCHING.getCommand())) {
                match();
            }
            if (option.equals(OptionCommand.CHECK.getCommand())) {
                check();
            }
            if (option.equals(OptionCommand.RESET.getCommand())) {
                reset();
            }
            if (option.equals(OptionCommand.QUIT.getCommand())) {
                break;
            }
        }
    }

    private String readOption() {
        outputView.printSelectOption();
        while (true) {
            try {
                return inputView.readOption();
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private void match() {
        MatchingConditions matchingConditions;
        while (true) {
            matchingConditions = readConditions();
            if (matchingService.hasConditions(matchingConditions)) {
                break;
            }
            outputView.printRematching();
            RematchingCommand rematching = RematchingCommand.from(inputView.readRematching());
            if (rematching == RematchingCommand.REMATCHING) {
                break;
            }
        }
        Pairs pairs = matchingService.matchPair(matchingConditions);
        outputView.printPairs(pairs);
    }

    private MatchingConditions readConditions() {
        outputView.printSelectCondition();
        while (true) {
            try {
                List<String> conditions = inputView.readConditions();
                return new MatchingConditions(conditions);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private void check() {
        Pairs pairs = checkPairs();
        outputView.printPairs(pairs);
    }

    private Pairs checkPairs() {
        while (true) {
            try {
                MatchingConditions matchingConditions = readConditions();
                return matchingService.findPairs(matchingConditions);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private void reset() {
        matchingService.resetData();
        outputView.printReset();
    }
}
