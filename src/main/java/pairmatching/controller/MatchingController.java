package pairmatching.controller;

import java.util.List;
import pairmatching.dto.MissionDto;
import pairmatching.repository.matching.CourseHistory;
import pairmatching.repository.matching.MatchingHistory;
import pairmatching.view.InputView;

public class MatchingController {
    private static final MatchingHistory matchingHistory = new MatchingHistory();
    private static final InputView inputView = new InputView();

    //OutputView

    public MatchingController (){
        resetPair();
    }

    public void createPair(){
        while(true){
            MissionDto missionDto = inputView.pairMatchingView();

            //매칭 정보가 있는지 확인
            //if 매칭 정보가 없다면
            if(true){
                //출력 - 생성된 페어 출력
                //return
            }
            //재입력 시도
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
