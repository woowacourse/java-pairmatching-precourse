package pairmatching.view;

import pairmatching.controller.PairMatchingController;
import pairmatching.utils.ErrorPrinter;

public class MainView {

    private static final String VIEW_HEADER = "기능을 선택하세요.";
    private static final String SELECTOR_MATCH = "1";
    private static final String SELECTOR_QUERY = "2";
    private static final String SELECTOR_INIT = "3";
    private static final String SELECTOR_QUIT = "Q";

    private static final String NAME_MATCH = "페어 매칭";
    private static final String NAME_QUERY = "페어 조회";
    private static final String NAME_INIT = "페어 초기화";
    private static final String NAME_QUIT = "종료";

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
    private final String menuBoard;
    private final PairMatchingController controller;
    private boolean exited = false;

    public MainView(PairMatchingController controller) {
        this.controller = controller;
        menuBoard = String.join(LINE_BREAK,
            VIEW_HEADER,
            menu(SELECTOR_MATCH, NAME_MATCH),
            menu(SELECTOR_QUERY, NAME_QUERY),
            menu(SELECTOR_INIT, NAME_INIT),
            menu(SELECTOR_QUIT, NAME_QUIT)
        );
    }

    private String menu(String selector, String name) {
        return String.join(DELIMITER, selector, name);
    }

    public void select() {
        action(() -> {
            String input = InputView.getLineWithPrompt(menuBoard);
            if (input.equals(SELECTOR_QUIT)) {
                exited = true;
                return;
            }
            select(input);
        });
    }

    private void select(String input) {
        if (input.equals(SELECTOR_MATCH)) {
            action(this::matchPair);
            return;
        }
        if (input.equals(SELECTOR_QUERY)) {
            showResult();
            return;
        }

        if (input.equals(SELECTOR_INIT)) {
            controller.invalidAllPairs();
            return;
        }
        throw new IllegalArgumentException(ERR_INALID_MENU);
    }

    public void showResult() {
        action(
            () -> {
                String input = InputView.getLineWithPrompt(MISSION_SELECT_PROMPT);
                String[] inputs = input.split(INPUT_DELIMITER);
                showResult(inputs[MISSION_INDEX], inputs[POSITION_INDEX], inputs[LEVEL_INDEX]);
            }
        );
    }

    private void showResult(String mission, String position, String level) {
        action(
            () -> ConsolePrinter.print(controller.getResult(mission, position, level))
        );
    }

    private void matchPair() {
        action(
            () -> {
                String input = InputView.getLineWithPrompt(MISSION_SELECT_PROMPT);
                String[] inputs = input.split(INPUT_DELIMITER);
                String mission = inputs[MISSION_INDEX];
                String position = inputs[POSITION_INDEX];
                String level = inputs[LEVEL_INDEX];
                if (!controller.matchPair(mission, position, level)) {
                    rematch(mission, position, level);
                }
                controller.matchPair(mission, position, level);
                showResult(mission, position, level);
            }
        );
    }

    private void rematch(String mission, String position, String level) {
        action(
            () -> {
                String input = InputView.getLineWithPrompt(MISSION_REMATCH);
                if (!input.equals(REMATCH_TRUE) && !input.equals(REMATCH_FALSE)) {
                    throw new IllegalArgumentException(ERR_INALID_INPUT_REMATCH);
                }
                if (input.equals(REMATCH_TRUE)) {
                    controller.matchPair(mission, position, level);
                }
            }
        );
    }

    private void action(Task task) {
        try {
            task.execute();
        } catch (IllegalArgumentException e) {
            ErrorPrinter.print(e);
            action(task);
        }
    }

    public boolean exited() {
        return this.exited;
    }
}
