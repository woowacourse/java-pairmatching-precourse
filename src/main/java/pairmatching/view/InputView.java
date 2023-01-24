package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getMainSelect() {
        System.out.println("\n기능을 선택하세요.\n" +
                "1. 페어 매칭\n" +
                "2. 페어 조회\n" +
                "3. 페어 초기화\n" +
                "Q. 종료");
        return Console.readLine();
    }

    public static String getMatchingInfo() {
        System.out.println("과정, 레벨, 미션을 선택하세요.\n" +
                "ex) 백엔드, 레벨1, 자동차경주");
        return Console.readLine();
    }

    public static String getConfirmRematch() {
        System.out.println("\n매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
                "네 | 아니오");
        return Console.readLine();
    }

    public static String getInquiryInfo() {
        System.out.println("과정, 레벨, 미션을 선택하세요.\n" +
                "ex) 백엔드, 레벨1, 자동차경주");
        return Console.readLine();
    }
}
