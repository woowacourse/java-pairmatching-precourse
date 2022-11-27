package pairmatching.controller;

import pairmatching.domain.MatchInfo;
import pairmatching.domain.Missions;
import pairmatching.service.MatchingService;


import static pairmatching.view.InputView.getMatchingInfo;
import static pairmatching.view.OutputView.printMatchPair;
import static pairmatching.view.OutputView.printMissionInfo;

public class MatchingController {
    public static final Missions missions = new Missions();
    public static final MatchingService matchingService = new MatchingService();
    public void run() {
        boolean flag = false;
        while(!flag) {
            try {
                printMissionInfo(missions);
                String input = getMatchingInfo();
                MatchInfo matchInfo = matchingService.matchPair(input, missions);
                printMatchPair(matchInfo);
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
