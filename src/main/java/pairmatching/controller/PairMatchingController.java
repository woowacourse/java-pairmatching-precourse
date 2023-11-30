package pairmatching.controller;


import static pairmatching.view.input.InputView.*;
import static pairmatching.view.input.InputView.reInputChooseProcess;
import static pairmatching.view.ouput.OutputView.displayProcessOfPair;
import static pairmatching.view.ouput.OutputView.printPairs;

import java.util.*;
import java.io.*;
import pairmatching.domain.Crew;
import pairmatching.domain.MatchingHistory;
import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;
import pairmatching.exception.ExceptionHandler;
import pairmatching.service.CrewService;
import pairmatching.service.MatchingService;
import pairmatching.util.Parser;
import pairmatching.view.input.InputView;

public class PairMatchingController {
    private final static MatchingHistory matchingHistory = MatchingHistory.of();
    private static String processInfo = "";

    private PairMatchingController() {
    }

    public  static void pairMatching() {
        displayProcessOfPair();
        List<Crew> crews = getCrewsFromProcess(getInput());
        MatchingCrews(crews);
    }

    private static String getInput(){
        processInfo = ExceptionHandler.retryOnBusinessException(InputView::inputChooseProcess);
        if (matchingHistory.isMatchingExist(processInfo)) {
            if (!reInputChooseProcess()) {
                return getInput();
            }
            matchingHistory.deleteMatchingResult(processInfo);
        }
        return processInfo;
    }

    private static List<Crew> getCrewsFromProcess(String processInput){
        List<String> processInfo = Parser.parseProcessInput(processInput);;
        Course course = Course.valueOf(processInfo.get(0));
        Level level = Level.valueOf(processInfo.get(1));
        String mission = processInfo.get(2);

        return CrewService.getCrews(course, level, mission);
    }

    private static void MatchingCrews(List<Crew> crews) {
        List<Crew> matchedCrews = MatchingService.matchingPair(crews);
        matchingHistory.recordMatchingResult(processInfo, matchedCrews);
        printPairs(matchedCrews);
    }
}