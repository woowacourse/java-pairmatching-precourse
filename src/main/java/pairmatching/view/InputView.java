package pairmatching.view;

import pairmatching.domain.MenuSelect;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String REQUEST_MENU = "기능을 선택하세요";
    public static final String PAIR_MATCHING_MENU = "1. 페어 매칭";
    public static final String PAIR_READ_MENU = "2. 페어 조회";
    public static final String PAIR_INITIALIZATION_MENU = "3. 페어 초기화";
    public static final String QUIT_MENU = "Q. 종료";

    public MenuSelect requestMenuSelect() {
        try {
            showMenu();
            return new MenuSelect(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestMenuSelect();
        }
    }

    private void showMenu() {
        System.out.println(REQUEST_MENU);
        System.out.println(PAIR_MATCHING_MENU);
        System.out.println(PAIR_READ_MENU);
        System.out.println(PAIR_INITIALIZATION_MENU);
        System.out.println(QUIT_MENU);
    }
}
