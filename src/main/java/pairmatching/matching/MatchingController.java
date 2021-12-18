package pairmatching.matching;

import pairmatching.GeneralInputView;
import pairmatching.GeneralOutputView;

public class MatchingController {
    private final MatchingService matchingService;

    public MatchingController() {
        matchingService = new MatchingService();
    }

    public String inputFunctionByUser() {
        String choice;
        try {
            String input = GeneralInputView.inputFunctionByClient();
            // 검증로직
            choice = input;

        } catch (IllegalArgumentException e) {
            choice = inputFunctionByUser();
        }
        return choice;
    }



    public void startMatching(){
        // 매칭 중복 확인로직
        // 매칭 로직
        seeMatchingInfo();
    }

    public void seeMatchingInfo(){
        MatchingOutputView.seeMatchingResult();
        // 결과 보여주기
    }

    public void resetMatching(){
        // 초기화 로직
        MatchingOutputView.resetFinishedPrint();
    }

}
