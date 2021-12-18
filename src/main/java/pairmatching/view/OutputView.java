package pairmatching.view;

public class OutputView {
    public static final String LINE_BREAK = "\n";
    public static final String REQUEST_CHOOSE_MENU = "기능을 선택하세요.";

    public static void requestChooseMenu() {
        System.out.println(REQUEST_CHOOSE_MENU);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage + LINE_BREAK);
    }
}
