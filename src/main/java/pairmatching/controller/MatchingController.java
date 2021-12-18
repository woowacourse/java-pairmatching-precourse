package pairmatching.controller;

import pairmatching.domain.Missions;

import static pairmatching.view.OutputViews.printMissionInfo;

public class MatchingController {
    public static final Missions missions = new Missions();

    public void run() {
        printMissionInfo(missions);
    }


}
