package pairmatching.controller;

import static pairmatching.util.Constants.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.CLM;
import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
    static String userInput;
    static InputValidator inputValidator;
    static HashMap<CLM, List<String>> fairMatch;

    public Controller() {
        userInput = "";
        inputValidator = new InputValidator();
        fairMatch = new HashMap<>();
    }

    public static void run() {
        while (!userInput.equals("Q")) {
            selectFunctions();
            printSelectedFunction();
        }

    }

    private static void selectFunctions() {
        try {
            userInput = InputView.selectFunctionMenu();
            inputValidator.functions(userInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e);
            selectFunctions();
        }
    }

    private static void printSelectedFunction() {
        if (userInput.equals(FAIR_MATCHING_OPT)) {
            fairMatchingFunction();
        } else if (userInput.equals(FAIR_LOOKUP_OPT)) {
            fairLookUpFunction();
        } else if (userInput.equals(FAIR_INIT_OPT)) {
            fairInitFunction();
        }
    }

    private static void fairMatchingFunction() {
        try {
            userInput = InputView.selectCLMMenu();
            inputValidator.CLM(userInput);
            CLM clm = new CLM(splitCLM(userInput));
            if (!checkFairMatchKey(clm)) {
                makeFairMatch(clm);
            } else {
                userInput = InputView.reMatching();
                if (userInput.equals("네")) {
                    makeFairMatch(clm);
                } else {
                    fairMatchingFunction();
                }
            }
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e);
            fairMatchingFunction();
        }
    }

    private static List<String> splitCLM(String userInput) {
        String tmp1 = userInput.replace(" ", "");
        return Arrays.asList(tmp1.split(","));
    }

    private static boolean checkFairMatchKey(CLM clm) {
        for (CLM key : fairMatch.keySet()) {
            if (clm.isSame(key, clm)) {
                return true;
            }
        }
        return false;
    }

    private static void makeFairMatch(CLM clm) {
        List<String> crewNames = InputView.readFile(BACKEND_CREW_DIR);
        String course = clm.getCourse();
        if (course.equals("프론트엔드")) {
            crewNames = InputView.readFile(FRONTEND_CREW_DIR);
        }
        List<String> fairs = Randoms.shuffle(crewNames);
        fairMatch.put(clm, fairs);
        OutputView.printFairMatchingResult(fairs);
    }

    private static void fairLookUpFunction() {
        try {
            userInput = InputView.selectCLMMenu();
            inputValidator.CLM(userInput);
            CLM clm = new CLM(splitCLM(userInput));
            if (!checkFairMatchKey(clm) || fairMatch.get(clm).isEmpty()) {
                OutputView.printWrongCLM();
                fairLookUpFunction();
            } else {
                OutputView.printFairMatchingResult(fairMatch.get(clm));
            }
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e);
            fairLookUpFunction();
        }
    }

    private static void fairInitFunction() {
        OutputView.printfairInitMsg();
        fairMatch = new HashMap<>();
    }

}
