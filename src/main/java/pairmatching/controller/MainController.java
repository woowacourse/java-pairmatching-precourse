package pairmatching.controller;

import java.io.IOException;

import pairmatching.domain.Crew;
import pairmatching.domain.Menu;
import pairmatching.domain.PairMatching;
import pairmatching.view.OutputView;

public class MainController {

    public void run() throws IOException {
        PairMatching.initCrews();

        System.out.println("Front 멤버");
        for (Crew crew : PairMatching.frontendCrews()) {
            System.out.println(crew.getName());
            System.out.println("\n");
        }
        System.out.println("Back 멤버");
        for (Crew crew : PairMatching.backendCrews()) {
            System.out.println(crew.getName());
            System.out.println("\n");
        }
        while (true) {
            String mainMenu = Menu.processOfSelectMenu();
            if (mainMenu.equals((Menu.MENU_PAIR_MATCHING))) {
                processOfPairMatching();
            } else if (mainMenu.equals(Menu.MENU_PAIR_LOOK_UP)) {

            } else if (mainMenu.equals(Menu.MENU_PAIR_INIT)) {

            } else if (mainMenu.equals(Menu.MENU_EXIT)) {
                break;
            }
        }
    }

    private void processOfPairMatching() {
        String courseLevelMission = Menu.processOfPairMatchingSelectMenu();
        System.out.println(courseLevelMission);
    }
}
