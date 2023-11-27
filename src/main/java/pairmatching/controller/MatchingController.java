package pairmatching.controller;

import java.util.Set;
import pairmatching.domain.MatchingService;
import pairmatching.domain.Pair;
import pairmatching.dto.MissionDto;
import pairmatching.view.InputView;

public class MatchingController {
    private static final MatchingService matchingService = new MatchingService();
    private static final InputView inputView = new InputView();

    //OutputView

    public MatchingController (){
        resetPair();
    }

    public void createPair(){
        inputView.pairMatchingView();
        while(true){
            MissionDto missionDto = inputView.getMissionDto();
            if(matchingService.isMatched(missionDto)){
                System.out.println("matched");
                if(!inputView.reMatching()){
                    matchingService.removeHistory(missionDto);
                    continue;
                }
            }

            //매칭 정보가 없다면
            Set<Pair> pairs = matchingService.matching(missionDto);
            System.out.println(pairs);
            return;
        }
    }

    public void readPair(){
        //매칭 정보가 있는지 확인
        //있으면 매칭 정보 출력
        //없으면 없다고 출력
    }

    public void resetPair(){
        //모든 매칭 정보 리셋
    }
}
