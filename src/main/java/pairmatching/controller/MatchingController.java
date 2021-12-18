package pairmatching.controller;

import jdk.internal.util.xml.impl.Input;
import pairmatching.domain.Pair;
import pairmatching.service.MatchingService;
import pairmatching.utils.DetailValidation;
import pairmatching.utils.ErrorMessage;
import pairmatching.utils.InputMessage;
import pairmatching.view.InputView;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MatchingController {

    private List<MatchingService> matchingServiceList;

    public  MatchingController(){
    }

    public String start(){
        //  기능 선택 질문하기
        InputView.askCaegory();
        // 선택지 입력받기
        String categoryAnswer = InputView.getCaegory();
        if(categoryAnswer=="Q"){
            return categoryAnswer;
        }
        //answer에 맞는 구체적인 질문 내용 가져오기
        while(true){
            try{
                getDetail(categoryAnswer);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(ErrorMessage.NOMISSION_EXIST);
            }
        }
        return categoryAnswer;
    }


    public void getDetail (String categoryAnswer) {
        if(categoryAnswer.equals("1")){
            //  구체적인 내용 질문
            InputView.askDetail();
            String detailAnswer = InputView.getDetail();

            String[] detailArray = detailAnswer.split(",");

            List<String> detailList = new ArrayList<String>(Arrays.asList(detailArray));

            boolean missionExistCheck = DetailValidation.missionExist(detailList);

            if(missionExistCheck==false){
                throw new IllegalArgumentException(
                        ErrorMessage.NOMISSION_EXIST
                );
            }

            MatchingService service = new MatchingService(detailArray[0], detailArray[1], detailArray[2]);

            // 현재 매칭 정보가 있는 지확인 하고 없으면 생성
//            if(matchingServiceList.contains(service)){
//                //존재합니다
//                InputView.existService();
//                String againAsnwer = InputView.getagainMatching();
//                if (againAsnwer.equals("아니오")){
//                    // 기존에 있는 매칭 출력
//                }
//
//            }

            // 페어링을 한다.
            service.getMatching();
            getResultMatching(service);
            return;
        }
        if(categoryAnswer.equals("2")){
            // 현재 있는 매칭 출력
            return;
        }
        if(categoryAnswer.equals("3")){
            return;
        }
        // 그외에 프로그램 종료

        return;
    }

    public void getResultMatching(MatchingService service){
        List<Pair> resultList = service.getShuffileResult();
        //홀수라면
        if(service.getIsOdd()){
            for(int i=0; i<resultList.size(); i++){
                Pair pair = resultList.get(i);
                if(i==resultList.size()-1){
                    System.out.println(pair.getName() + " : " + pair.getPairName() + " : " + service.getExtraName());
                    return;
                }
                System.out.println(pair.getName() + " : " + pair.getPairName());
            }
            return;
        }
        //짝수라면
        for(int i=0; i<resultList.size(); i++){
            Pair pair = resultList.get(i);
            System.out.println(pair.getName() + " : " + pair.getPairName());
        }
    }

}

