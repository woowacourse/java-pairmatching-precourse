package pairmatching.view;

import pairmatching.domain.MenuCommand;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class OutputView {
    private static final String WHOLE_COURSE_MISSIONS =
            "\n#############################################\n"
                    + "과정: 백엔드 | 프론트엔드\n"
                    + "미션:\n"
                    + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
                    + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
                    + "  - 레벨3: \n"
                    + "  - 레벨4: 성능개선 | 배포\n"
                    + "  - 레벨5: \n"
                    + "############################################\n";
    private static final String PAIRS_RESET_MESSAGE = "초기화 되었습니다.";

    public void printWholeCourseMissions(){
        System.out.println(WHOLE_COURSE_MISSIONS);
    }

    public void printErrorMessage(String message){
        System.out.println(message);
    }

    public void printMatchingResult(String result){
        System.out.println("페어 매칭 결과입니다.");
        System.out.println(result);
    }

    public void printPairsResetMessage(){
        System.out.println(PAIRS_RESET_MESSAGE);
    }
}
