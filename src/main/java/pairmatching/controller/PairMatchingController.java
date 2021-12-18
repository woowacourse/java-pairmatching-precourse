package pairmatching.controller;

import java.io.IOException;
import java.util.ArrayList;

import pairmatching.domain.Crew;
import pairmatching.util.Initializer;

public class PairMatchingController {
    ArrayList<Crew> backEndCrews;
    ArrayList<Crew> frontEndCrews;

    public PairMatchingController() {
        registerCrews();
    }

    private void registerCrews() {
        try {
            backEndCrews = Initializer.registerBackEndCrews();//IOEEXCEPTION 날 수 있음.
            frontEndCrews = Initializer.registerFrontEndCrews();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        System.out.println("dd");
        for (Crew backEndCrew : backEndCrews) {
            System.out.println("backEndCrew = " + backEndCrew);
        }
        System.out.println("dad");
        for (Crew frontEndCrew : frontEndCrews) {
            System.out.println("frontEndCrew = " + frontEndCrew);
        }
    }
}
