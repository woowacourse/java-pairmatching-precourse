package pairmatching.view;

import pairmatching.controller.PairMatchingController;
import pairmatching.utils.ErrorPrinter;

public class MissionView {

    private static final String DELIMITER = ". ";
    private static final String LINE_BREAK = "\n";
    private static final String INPUT_DELIMITER = ", ";
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;
    private static final int POSITION_INDEX = 0;
    private static final String MISSION_SELECT_PROMPT = "";
    private static final String ERR_INALID_MENU = "없는 기능입니다.";
    private static final String MISSION_REMATCH = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";
    private static final String REMATCH_TRUE = "네";
    private static final String REMATCH_FALSE = "아니오";
    private static final String ERR_INALID_INPUT_REMATCH = "네 아니오로 입력해쥇요.";
    private static final String MISSION_BOARD = "#############################################\n"
        + "과정: 백엔드 | 프론트엔드\n"
        + "미션:\n"
        + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
        + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
        + "  - 레벨3: \n"
        + "  - 레벨4: 성능개선 | 배포\n"
        + "  - 레벨5: \n"
        + "############################################\n"
        + "과정, 레벨, 미션을 선택하세요.\n"
        + "ex) 백엔드, 레벨1, 자동차경주\n"
        + "프론트엔드, 레벨1, 자동차경주";
    private final PairMatchingController controller;

    public MissionView(PairMatchingController controller) {
        this.controller = controller;
    }
    public void showResult() {
        action(
            () -> {
                String[] inputs = getMissionQuery();
                showResult(inputs[MISSION_INDEX], inputs[POSITION_INDEX], inputs[LEVEL_INDEX]);
            }
        );
    }

    public void showResult(String mission, String position, String level) {
        action(
            () -> ConsolePrinter.print(controller.getResult(mission, position, level))
        );
    }

    public void matchPair() {
        action(
            () -> {
                String[] inputs = getMissionQuery();
                String mission = inputs[MISSION_INDEX];
                String position = inputs[POSITION_INDEX];
                String level = inputs[LEVEL_INDEX];
                if (!controller.matchPair(mission, position, level)) {
                    rematch(mission, position, level);
                }
                showResult(mission, position, level);
            }
        );
    }

    public void rematch(String mission, String position, String level) {
        action(
            () -> {
                String input = InputView.getLineWithPrompt(MISSION_REMATCH);
                validateRematchSelector(input);
                if (input.equals(REMATCH_TRUE)) {
                    controller.matchPair(mission, position, level);
                }
            }
        );
    }


    private String[] getMissionQuery() {
        ConsolePrinter.print(MISSION_BOARD);
        String input = InputView.getLineWithPrompt(MISSION_SELECT_PROMPT);
        return input.split(INPUT_DELIMITER);
    }

    private void validateRematchSelector(String input) {
        if (!input.equals(REMATCH_TRUE) && !input.equals(REMATCH_FALSE)) {
            throw new IllegalArgumentException(ERR_INALID_INPUT_REMATCH);
        }
    }

    private void action(Task task) {
        try {
            task.execute();
        } catch (IllegalArgumentException e) {
            ErrorPrinter.print(e);
            action(task);
        }
    }
}
