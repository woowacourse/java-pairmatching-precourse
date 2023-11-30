package pairmatching.controller;


import static pairmatching.view.input.InputView.inputChooseProcess;
import static pairmatching.view.ouput.OutputView.printPairs;

import java.util.*;
import java.io.*;
import pairmatching.domain.Crew;
import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;
import pairmatching.service.CrewService;
import pairmatching.service.MatchingService;

public class PairMatchingController {

    private PairMatchingController() {
    }

    public  static void pairMatching() {
        List<Crew> crews = getCrewsFromProcess();
        MatchingCrews(crews);
    }

    private static List<Crew> getCrewsFromProcess(){
        List<String> processInfo = inputChooseProcess();
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