package view;

public class OutputView {
    private static final String PAIR_MATCHING = "1. 페어매칭";
    private static final String PAIR_SEARCH = "2. 페어 조회";
    private static final String PAIR_INITIALIZE = "3. 페어 초기화";
    private static final String EXIT_PROGRAM = "Q. 종료";
    
    public static void showMain() {
        System.out.println(PAIR_MATCHING);
        System.out.println(PAIR_SEARCH);
        System.out.println(PAIR_INITIALIZE);
        System.out.println(EXIT_PROGRAM);
    }
}
