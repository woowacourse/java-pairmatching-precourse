package pairmatching.view;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    private enum ConsoleMessage {
        OUTPUT_PAIR_MATCHING_RESULT("페어 매칭 결과입니다."),
        OUTPUT_PAIR_INITIALIZED("초기화 되었습니다. ");
        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

}