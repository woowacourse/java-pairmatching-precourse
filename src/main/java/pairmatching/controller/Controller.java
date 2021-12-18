package pairmatching.controller;

import static pairmatching.util.Constants.*;

import java.util.ArrayList;
import java.util.List;

import pairmatching.view.InputView;

public class Controller {
    List<String> backend_crew;
    List<String> frontend_crew;

    public Controller() {
        backend_crew = InputView.readFile(BACKEND_CREW_DIR);
        frontend_crew = InputView.readFile(FRONTEND_CREW_DIR);
    }

    public static void run() {
        selectFunctions();
    }

    private static String selectFunctions() {
        return InputView.selectFunction();
    }
}
