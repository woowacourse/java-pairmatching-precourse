package pairmatching.view;

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
    private final String menuBoard;

    public MainView() {
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
        String input = InputView.getLineWithPrompt(menuBoard);
        if (input.equals(SELECTOR_QUIT)) {
            return;
        }
        select(input);
    }

    private void select(String input) {
        if (input.equals(SELECTOR_MATCH)) {
            // MATCH
        }

        if (input.equals(SELECTOR_QUERY)) {
            // show
        }

        if (input.equals(SELECTOR_INIT)) {
            // init
        }
    }
}
