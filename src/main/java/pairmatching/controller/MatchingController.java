package pairmatching.controller;

import java.util.HashSet;
import java.util.Set;
import pairmatching.domain.MatchingService;
import pairmatching.domain.Pair;
import pairmatching.dto.MissionDto;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
    private static final MatchingService matchingService = new MatchingService();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

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
            outputView.printMatchingResult(pairs);

            return;
        }
    }

    public void readPair(){
        MissionDto missionDto = inputView.getMissionDto();
        if(matchingService.isMatched(missionDto)){
            outputView.printMatchingResult(matchingService.getResult(missionDto));
            return;
        }
        throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.");
    }

    public void resetPair(){
        matchingService.reset();
    }
}
