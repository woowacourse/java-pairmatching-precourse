package pairmatching.view;

import pairmatching.domain.Level;
import pairmatching.domain.validation.Text;

public class OutputView {
    public static final String LINE_BREAK = "\n";
    public static final String REQUEST_CHOOSE_MENU = "기능을 선택하세요.";
    public static final String REQUEST_INFORMATION = "과정, 레벨, 미션을 선택하세요." + LINE_BREAK + "ex) 백엔드, 레벨1, 자동차경주";
    public static final String EXISTS_MATCHING = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?" + LINE_BREAK + "네 | 아니오";

    public static void requestChooseMenu() {
        System.out.println(REQUEST_CHOOSE_MENU);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage + LINE_BREAK);
    }

    public static void printInformation(Level[] level) {
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");

        for (int i = 0; i < Text.MISSION_NAME.length; i++) {
            System.out.print("- " + level[i].toString() + ": ");
            System.out.println(String.join(" | ", Text.MISSION_NAME[i]));
        }

        System.out.println("#############################################");
    }

    public static void requestInformation() {
        System.out.println(REQUEST_INFORMATION);
    }

    public static void existsMatching() {
        System.out.println("");
    }
}
