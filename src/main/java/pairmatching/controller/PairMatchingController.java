package pairmatching.controller;

import pairmatching.service.CrewService;
import pairmatching.service.PairMatchingService;
import pairmatching.util.InputSign;
import pairmatching.util.Symbol;
import pairmatching.view.PairMatchingInputView;
import pairmatching.view.PairMatchingOutputView;

public class PairMatchingController {
    private final CrewService crewService;
    private final PairMatchingService pairMatchingService;
    private final PairMatchingInputView pairMatchingInputView;
    private final PairMatchingOutputView pairMatchingOutputView;

    public PairMatchingController() {
        this.crewService = new CrewService();
        this.pairMatchingService = new PairMatchingService();
        this.pairMatchingInputView = new PairMatchingInputView();
        this.pairMatchingOutputView = new PairMatchingOutputView();
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
            if (function.equals(InputSign.SIGN_QUIT)) {
                break;
            }
            if (function.equals(InputSign.SIGN_MATCH)) {
                matchPair();
            }
            if (function.equals(InputSign.SIGN_VIEW)) {
                viewPair();
            }
            if (function.equals(InputSign.SIGN_RESET)) {
                resetPair();
            }
        }
    }

    private void matchPair() {
        pairMatchingOutputView.outputMatchingInfo(pairMatchingService.getAllCourse(), pairMatchingService.getAllMission());
        String[] matchingInfo = pairMatchingInputView.inputMatchingInfo();
        String result = pairMatchingService.getPariMatchingResult(matchingInfo, crewService.getCrews(matchingInfo[0]));
    }

    private void viewPair() {

    }

    private void resetPair() {

    }
}
