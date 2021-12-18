package pairmatching.view;

public class MatchingView {
    private static final String MATCHING_PROMPT = "\n#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n" +
            "############################################";
    private static final String SELECT_PROMPT = "\n과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주";
    private static final String SHOULD_REMATCH_MESSAGE = "\n매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" + "네 | 아니오";

    public static void printMatchingPrompt() {
        System.out.println(MATCHING_PROMPT);
    }

    public static void printSelectPrompt() {
        System.out.println(SELECT_PROMPT);
    }

    public static void printShouldRematch() {
        System.out.println(SHOULD_REMATCH_MESSAGE);
    }
}
