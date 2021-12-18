package pairmatching.view;

import java.util.HashMap;
import java.util.Map;
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
    private final String menuBoard;
    private final PairMatchingController controller;
    private final MissionView missionView;
    private final Map<String, Task> menu = new HashMap<>();
    private boolean exited = false;

    public MainView(PairMatchingController controller) {
        this.controller = controller;
        this.missionView = new MissionView(controller);
        menuBoard = String.join(LINE_BREAK,
            VIEW_HEADER,
            menu(SELECTOR_MATCH, NAME_MATCH),
            menu(SELECTOR_QUERY, NAME_QUERY),
            menu(SELECTOR_INIT, NAME_INIT),
            menu(SELECTOR_QUIT, NAME_QUIT)
        );
        menu.put(SELECTOR_MATCH, missionView::matchPair);
        menu.put(SELECTOR_QUERY, missionView::showResult);
        menu.put(SELECTOR_INIT, controller::invalidAllPairs);
        menu.put(SELECTOR_QUIT, this::quit);
    }

    private void quit() {
        this.exited = true;
    }

    private String menu(String selector, String name) {
        return String.join(DELIMITER, selector, name);
    }

    public void select() {
            String input = InputView.getLineWithPrompt(menuBoard);
            menu.get(input).execute();
    }

    public boolean exited() {
        return this.exited;
    }
}
