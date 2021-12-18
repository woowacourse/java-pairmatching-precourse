package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.PairMatching;

public class InputView {
    private static final String FUNCTION_GUIDE_MESSAGE = "기능을 선택하세요.\n" + "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";

    private String init () {
        System.out.println(FUNCTION_GUIDE_MESSAGE);
        return Console.readLine();
    }

    public void inputFunction() {
        while(true) {
            String function = init();
            if (function.equals("1")){
                PairMatching.matching();
            }
        }
    }
}
