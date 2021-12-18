package pairmatching.controller;

import static pairmatching.util.Constants.*;

import java.util.ArrayList;
import java.util.List;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
    static String userInput;
    List<String> backend_crew;
    List<String> frontend_crew;

    public Controller() {
        userInput = "";
        backend_crew = InputView.readFile(BACKEND_CREW_DIR);
        frontend_crew = InputView.readFile(FRONTEND_CREW_DIR);
    }

    public static void run() {
        while (!userInput.equals("Q")) {
            userInput = selectFunctions();
            printSelected(userInput);
        }
    }

    private static String selectFunctions() {
        return InputView.selectFunctionMenu();
    }

    private static void printSelected(String userInput) {
        if (!userInput.equals("3")) {
            String userCLM = InputView.selectCLMMenu();
            if (userInput.equals("1")) {
                OutputView.printFairMatchingResult(userCLM);
            } else if (userInput.equals("2")) {

            }
        } else {

        }
    }

    private


}
