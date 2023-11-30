package pairmatching.controller;

import static pairmatching.exception.ErrorCode.*;
import static pairmatching.view.input.InputView.inputChooseProcess;
import static pairmatching.view.input.InputView.reInputChooseProcess;
import static pairmatching.view.ouput.OutputView.displayProcessOfPair;
import static pairmatching.view.ouput.OutputView.printPairs;

import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.MatchingHistory;
import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;
import pairmatching.service.CrewService;
import pairmatching.util.Parser;

public class PairInquiryController {
    private static MatchingHistory matchingHistory = MatchingHistory.of();
    private PairInquiryController(){
    }

    public static void pairInquiry() {
        displayProcessOfPair();
        reponsePairResult(getInput());
    }

    private static String getInput(){
        String processInfo = inputChooseProcess();
        NO_EXIST_MATCHING_HISTORY.validate(() -> matchingHistory.isMatchingExist(processInfo));
        return processInfo;
    }

    private static void reponsePairResult(String processInfo){
        List<Crew> crewsResult = matchingHistory.getMatchingResult(processInfo);
        printPairs(crewsResult);
    }

}
