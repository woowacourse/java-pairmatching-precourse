package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String MENU_MESSAGE = "기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";

    public static String readMenu() {
        System.out.println(MENU_MESSAGE);
        String input = readString();
        return input;
    }

    private static String readString() {
        String input = Console.readLine().trim();
        validateBlank(input);
        return input;
    }

    private static void validateBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    public static String readRematch() {
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
        return readString();
    }
}
