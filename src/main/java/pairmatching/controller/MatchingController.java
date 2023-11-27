package pairmatching.controller;

import java.util.List;
import java.util.Set;
import pairmatching.domain.MatchingService;
import pairmatching.domain.Pair;
import pairmatching.dto.MissionDto;
import pairmatching.repository.matching.CourseHistory;
import pairmatching.repository.matching.MatchingHistory;
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
                //매칭 정보가 있으면 다시 매칭할건지 물어봐야됨
                //다시 매칭할거라 하면 continue 써서 다시 입력 받게
            }

            //매칭 정보가 없다면
            Set<Pair> pairs = matchingService.matching(missionDto);
        }
    }

    //매칭 정보가 있는지 확인
    private boolean isMatchedMission(){
        return false;
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
