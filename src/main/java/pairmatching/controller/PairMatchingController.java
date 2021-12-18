package pairmatching.controller;

import pairmatching.domain.ProgramInfo;
import pairmatching.service.PairMatchingService;
import pairmatching.util.ProgramInfoTransformer;
import pairmatching.view.InputView;

public class PairMatchingController {
    PairMatchingService pairMatchingService = new PairMatchingService();
    InputView inputView = new InputView();

    public void run() {
        while (true) {
            inputView.determineMainFunction(); // TODO : 기능 선택은 나중에 하자.
            ProgramInfo programInfo = matchPairs();//1. 페어 매칭 선택했을 때 사용할 메서드.

            pairMatchingService.matchPairs(programInfo);
            System.out.println(programInfo);
        }
    }

    private ProgramInfo matchPairs() {
        try {
            ProgramInfo programInfo = ProgramInfoTransformer.makeProgramInfo(inputView.determineProgramInfo());
            if (pairMatchingService.isAlreadyMatching(programInfo)) {
                inputView.determineReMatching();
                // TODO 네 하면 밑으로, 아니오 하면 다시 함수.
                programInfo.clearPairs();
            }
            return programInfo;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return matchPairs();
        }
    }
}
