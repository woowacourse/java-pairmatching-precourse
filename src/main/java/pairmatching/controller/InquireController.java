package pairmatching.controller;

import pairmatching.service.InqueryService;

import static pairmatching.controller.MatchingController.missions;
import static pairmatching.view.InputView.getInqueryInfo;
import static pairmatching.view.OutputView.printMatchPair;
import static pairmatching.view.OutputView.printMissionInfo;

public class InqueryController {
    private static final InqueryService inqueryService = new InqueryService();

    public void run() {
        boolean flag = false;
        while (!flag) {
            try {
                printMissionInfo(missions);
                printMatchInfo(getInqueryInfo());
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printMatchInfo(String input) {
        printMatchPair(inqueryService.getMatchInfo(input));
    }
}
