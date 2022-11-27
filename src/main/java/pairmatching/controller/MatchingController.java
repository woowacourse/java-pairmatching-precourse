package pairmatching.controller;

import pairmatching.Missions;

import static pairmatching.view.OutputView.printCourseAndMission;
public class MatchingController {
    public  static final Missions missions = new Missions();

    public void run() {
        printCourseAndMission(missions);
    }
}
