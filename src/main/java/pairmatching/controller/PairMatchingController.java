package pairmatching.controller;

import java.io.IOException;
import java.util.ArrayList;

import pairmatching.domain.Crew;
import pairmatching.util.Initializer;
import pairmatching.view.InputView;

public class PairMatchingController {
    ArrayList<Crew> backEndCrews;
    ArrayList<Crew> frontEndCrews;
    InputView inputView = new InputView();

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
        inputView.determineMainFunction(); // TODO : 기능 선택은 나중에 하자.
        inputView.determineProgramInfo();
    }
}
