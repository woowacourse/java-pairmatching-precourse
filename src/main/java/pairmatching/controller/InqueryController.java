package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.service.InqueryService;
import pairmatching.service.MatchingSercive;

import static pairmatching.controller.MatchingController.missions;
import static pairmatching.utils.Validator.checkInfoCount;
import static pairmatching.view.InputViews.getInqueryInfo;
import static pairmatching.view.OutputViews.printMatchPair;
import static pairmatching.view.OutputViews.printMissionInfo;

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
