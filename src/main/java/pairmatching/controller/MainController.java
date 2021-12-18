package pairmatching.controller;

import java.io.IOException;

import pairmatching.domain.Crew;
import pairmatching.domain.Menu;
import pairmatching.domain.PairMatching;
import pairmatching.view.OutputView;

public class MainController {
    Menu menu = new Menu();



    public void run() throws IOException{
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

    }
}
