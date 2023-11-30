package pairmatching.controller;


import static pairmatching.view.input.InputView.*;
import static pairmatching.view.input.InputView.reInputChooseProcess;
import static pairmatching.view.ouput.OutputView.printPairs;

import java.util.*;
import java.io.*;
import pairmatching.domain.Crew;
import pairmatching.domain.MatchingHistory;
import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;
import pairmatching.service.CrewService;
import pairmatching.service.MatchingService;
import pairmatching.util.Parser;

public class PairMatchingController {
    private static MatchingHistory matchingHistory = MatchingHistory.of();

    private PairMatchingController() {
    }

    public  static void pairMatching() {
        List<Crew> crews = getCrewsFromProcess(getInput());
        MatchingCrews(crews);
    }

    private static String getInput(){
        String processInfo = inputChooseProcess();
        if (matchingHistory.isMatchingExist(processInfo)) {
            if (!reInputChooseProcess()) {
                return getInput();
            }
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
        printPairs(matchedCrews);
    }

}