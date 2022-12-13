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

    public void printFailMatching() {
        System.out.println(Message.OUTPUT_FAIL_PAIR_MATCHING.message);
    }

    private enum Message {
        OUTPUT_PAIR_MATCHING_RESULT("페어 매칭 결과입니다."),
        OUTPUT_PAIR_INITIALIZED("초기화 되었습니다. "),
        OUTPUT_FAIL_PAIR_MATCHING("매칭에 실패하였습니다. 메인 화면으로 돌아갑니다.");
        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

}