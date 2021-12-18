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
            backEndCrews = Initializer.registerBackEndCrews();
            frontEndCrews = Initializer.registerFrontEndCrews();
        } catch (IOException e) {
            System.out.println(e.getMessage()); // IllegalArgument가 아니고 내가 예상 못한 예외니까 그냥 프로그램 터치는 게 맞다고 생각함.
        }
    }

    public void run() {
    }
}
