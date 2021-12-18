package pairmatching.controller;

import pairmatching.service.CrewService;
import pairmatching.service.PairMatchingService;
import pairmatching.view.PairMatchingInputView;

public class PairMatchingController {
    private final CrewService crewService;
    private final PairMatchingService pairMatchingService;
    private final PairMatchingInputView pairMatchingInputView;

    public PairMatchingController() {
        this.crewService = new CrewService();
        this.pairMatchingService = new PairMatchingService();
        this.pairMatchingInputView = new PairMatchingInputView();
    }

    public void run() {
        /* TODO:
            2. 선택한 기능 수행
         */
        setCrewList();
        executePairMatching();
    }

    private void setCrewList() {
        crewService.initCrewsByReader();
    }

    private void executePairMatching() {
        while (true) {
            String function = pairMatchingInputView.inputSelectFunction();
            if (pairMatchingService.isQuit(function)) {
                break;
            }
        }
    }
}
