package pairmatching.ui;

import static pairmatching.ui.InputReader.getUserInput;
import static pairmatching.ui.Messages.INVALID_RETRY_INPUT;

public class InputView {
    private static final String CHOOSE_MENU_OPENING = "기능을 선택하세요.";
    private static final String MAIN_MENU = "1. 페어 매칭\n" + "2. 페어 조회\n"
            + "3. 페어 초기화\n" + "Q. 종료";
    private static final String PAIR_MATCHING_BOARD = "#############################################\n"
            + "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3: \n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5: \n"
            + "############################################";
    private static final String CHOOSE_INFOS_OPENING = "과정, 레벨, 미션을 선택하세요.\n ex) 백엔드, 레벨1, 자동차경주";

    private static final String ASK_REMATCH = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
            + "네 | 아니오";

    public String inputMenuChoice() {
        System.out.println(CHOOSE_MENU_OPENING);
        System.out.println(MAIN_MENU);
        return getUserInput();
    }

    public void showMatchingMenu() {
        System.out.println('\n' + PAIR_MATCHING_BOARD);
    }

    public String inputPairMatching() {
        System.out.println('\n' + CHOOSE_INFOS_OPENING);
        return getUserInput();
    }

    public String inputRematchTry(){
        System.out.println(ASK_REMATCH);
        String userInput = getUserInput();
        if (!userInput.matches("네|아니오")){
            throw new IllegalArgumentException(INVALID_RETRY_INPUT.getMessage());
        }
        return userInput;
    }
}
