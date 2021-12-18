package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class GeneralInputView {
    public static final String START_MATCH = "1";
    public static final String SEE_MATCH = "2";
    public static final String INIT_MATCH = "3";
    public static final String QUIT = "Q";

    public static String inputFunctionByClient() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        return Console.readLine();
    }

    public static String inputCourseByClient() {
        System.out.println();
        GeneralOutputView.preCourseInfoPrint();
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        return Console.readLine();
    }
}
