package pairmatching.controller;

import pairmatching.code.MainCode;
import pairmatching.domain.ProgramInfo;
import pairmatching.service.PairMatchingService;
import pairmatching.util.ProgramInfoTransformer;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    PairMatchingService pairMatchingService = new PairMatchingService();
    InputView inputView = new InputView();
    MainCode mainCode = MainCode.MATCHING;
    public void run() {
        while (mainCode != MainCode.QUIT) {
            MainCode mainCode = MainCode.find(inputView.determineMainFunction());
            if (mainCode == MainCode.QUIT) {
                break;
            }
            if (mainCode == MainCode.MATCHING) {
                ProgramInfo programInfo = matchPairs();//1. 페어 매칭 선택했을 때 사용할 메서드.
                pairMatchingService.matchPairs(programInfo);
            }
            if (mainCode == MainCode.SEARCH) {
                searchProgramsPair();
            }
            if (mainCode == MainCode.INITIALIZE) {

            }
        }
    }

    private void searchProgramsPair() {
        ProgramInfo programInfo = ProgramInfoTransformer.makeProgramInfo(inputView.determineProgramInfo());
        if (pairMatchingService.hasProgramInfo(programInfo)) {
            System.out.println(programInfo);
            // OutputView.
            return;
        }
        System.out.println("해당되는 미션은 아직 매칭되지 않았습니다.");
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
