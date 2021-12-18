package pairmatching.controller;

import static pairmatching.ErrorMessage.*;

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
        try {
            executeFunction();
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            run();
        }
    }

    private void executeFunction() {
        while (mainCode != MainCode.QUIT) {
            MainCode mainCode = MainCode.find(inputView.determineMainFunction());
            if (mainCode == MainCode.QUIT) {
                break;
            }
            if (mainCode == MainCode.MATCHING) {
                ProgramInfo programInfo = matchPairs();//1. 페어 매칭 선택했을 때 사용할 메서드.

                if (!isRematching(programInfo)) {
                    continue;
                }
                pairMatchingService.matchPairs(programInfo);

            }
            if (mainCode == MainCode.SEARCH) {
                searchProgramsPair();
            }
            if (mainCode == MainCode.INITIALIZE) {
                pairMatchingService.clearAllMatchingInfo();
            }
        }
    }

    private boolean isRematching(ProgramInfo programInfo) {
        if (pairMatchingService.isAlreadyMatching(programInfo)) {
            String rematchingCode = inputView.determineReMatching();
            if (rematchingCode.equals("아니오")) {
                return false;
            }
            if (rematchingCode.equals("네")) {
                programInfo.clearPairs();
                return true;
            }
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        return true;
    }

    private void searchProgramsPair() {
        ProgramInfo programInfo = ProgramInfoTransformer.makeProgramInfo(inputView.determineProgramInfo());
        if (pairMatchingService.hasProgramInfo(programInfo)) {
            programInfo = pairMatchingService.getThisProgramInfo(programInfo);
            OutputView.showThisProgramPair(programInfo);
            return;
        }
        System.out.println("해당되는 미션은 아직 매칭되지 않았습니다.");
    }

    private ProgramInfo matchPairs() {
        try {
            ProgramInfo programInfo = ProgramInfoTransformer.makeProgramInfo(inputView.determineProgramInfo());
            return programInfo;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return matchPairs();
        }
    }
}
