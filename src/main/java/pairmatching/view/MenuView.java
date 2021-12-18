package pairmatching.view;

import java.util.ArrayList;

public class MenuView {
    public static final String PAIR_MATCHING = "1. 페어 매칭";
    public static final String PAIR_CHECK = "2. 페어 조회";
    public static final String PAIR_RESET = "3. 페어 초기화";
    public static final String PROGRAM_END = "Q. 종료";

    public static void setMenu(ArrayList<String> menu) {
        menu.add(PAIR_MATCHING);
        menu.add(PAIR_CHECK);
        menu.add(PAIR_RESET);
        menu.add(PROGRAM_END);
    }

    public static void printMenu() {
        ArrayList<String> menu = new ArrayList<>();
        setMenu(menu);
        menu.stream().forEach(System.out::println);
    }
}
