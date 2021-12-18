package pairmatching.controller;

import jdk.internal.util.xml.impl.Input;
import pairmatching.service.MatchingService;
import pairmatching.utils.InputMessage;
import pairmatching.view.InputView;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MatchingController {

    private List<MatchingService> matchingServiceList;

    public  MatchingController(){
    }

    public void start(){
        //  기능 선택 질문하기
        InputView.askCaegory();
        // 선택지 입력받기
        String categoryAnswer = InputView.getCaegory();
        //answer에 맞는 구체적인 질문 내용 가져오기
        getDetail(categoryAnswer);
    }


    public void getDetail (String categoryAnswer) {
        if(categoryAnswer.equals("1")){
            //  구체적인 내용 질문
            InputView.askDetail();
            String detailAnswer = InputView.getDetail();
            System.out.println(detailAnswer);
            String[] detailArray = detailAnswer.split(",");
            List<String> detailList = new ArrayList<String>(Arrays.asList(detailArray));

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
        }
        if(categoryAnswer.equals("2")){
            // 현재 있는 매칭 출력

        }
        if(categoryAnswer.equals("3")){
            
        }
        // 그외에 프로그램 종료
        return;
    }

}

