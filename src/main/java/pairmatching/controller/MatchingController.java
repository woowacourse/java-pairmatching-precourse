package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Missions;
import pairmatching.service.MatchingSercive;

import static pairmatching.utils.ExceptionMessage.*;
import static pairmatching.utils.Validator.*;
import static pairmatching.view.InputViews.getMainSelect;
import static pairmatching.view.InputViews.getMatchingInfo;
import static pairmatching.view.OutputViews.printMissionInfo;

public class MatchingController {
    public static final Missions missions = new Missions();
    static final MatchingSercive matchingService = new MatchingSercive();

    public void run() {
        boolean flag = false;
        while (!flag) {
            try {
                printMissionInfo(missions);
                String input = getMatchingInfo();
                matchingService.checkMissionInfo(input, missions);
                System.out.println("성공");
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
