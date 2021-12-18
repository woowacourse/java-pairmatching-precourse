package pairmatching.domain.enumeration;

import pairmatching.domain.Pairs;
import pairmatching.service.PairService;
import pairmatching.utils.ConstantMessages;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public enum MainFeature {
    PAIR_MATCHING("1", (inputArr) -> {
        if (isReMatchingNeeded(inputArr)) {
            return null;
        }
        return PairService.createPairs(inputArr);
    }),
    PAIR_FIND("2", (inputArr) -> {
        return PairService.findPairs(inputArr);
    }),
    PAIR_RESET("3", (inputArr) -> {
        PairService.resetPairs();
        OutputView.printResetAll();
        return new Pairs();
    }),
    QUIT("Q", (pairService) -> {
        return null;
    });


    private String input;
    private Function<String[], Pairs> function;


    MainFeature(String input, Function<String[], Pairs> function) {
        this.input = input;
        this.function = function;
    }

    public String getInput() {
        return input;
    }


    public static MainFeature findFeatureByInput(String input) {
        return Arrays.stream(MainFeature.values())
                .filter(mainFeature -> mainFeature.getInput().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ConstantMessages.PREFIX_ERROR + ConstantMessages.ERROR_INVALID_INPUT));
    }

    public Pairs apply(String[] inputArr) {
        return function.apply(inputArr);
    }


    private static boolean isReMatchingNeeded(String[] inputArr) {
        if(PairService.isMissionAlreadyHasPair(inputArr)) {
            if(MatchingResponse.findResponseByInput(InputView.insertReMatching()) == MatchingResponse.NO) {
                return true;
            }
        }
        return false;
    }
}
