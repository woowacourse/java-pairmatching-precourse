package pairmatching.controller;

import java.io.IOException;
import java.util.ArrayList;

import pairmatching.domain.Crew;
import pairmatching.domain.ProgramInfo;
import pairmatching.service.PairMatchingService;
import pairmatching.util.Initializer;
import pairmatching.util.ProgramInfoTransformer;
import pairmatching.view.InputView;

public class PairMatchingController {
    PairMatchingService pairMatchingService = new PairMatchingService();
    InputView inputView = new InputView();

    public void run() {
        inputView.determineMainFunction(); // TODO : 기능 선택은 나중에 하자.

        matchPairs(); //1. 페어 매칭 선택했을 때 사용할 메서드.
    }

    private void matchPairs() {
        ProgramInfo programInfo = ProgramInfoTransformer.makeProgramInfo(inputView.determineProgramInfo());
        //TODO: programInfoRepository에서 해당 정보로 저장되어있는 애가 있나 확인한다. -> 하나만 저장 가능하니까 map으로 구현하자. linked로 초기값 전부 0 넣어주면 되려나.
        // 존재한다면 -> 덮어쓸지 물어본다. 나중에 구현할거.

        pairMatchingService.matchPairs(programInfo);

        // 매칭을 저장소에 넣어준다.
    }
}
