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

    public static String readOption() {
        System.out.println("#############################################\n"
                + "    과정: 백엔드 | 프론트엔드\n"
                + "    미션:\n"
                + "      - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
                + "      - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
                + "      - 레벨3: \n"
                + "      - 레벨4: 성능개선 | 배포\n"
                + "      - 레벨5: \n"
                + "    ############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.\n"
                + "    ex) 백엔드, 레벨1, 자동차경주");
        return readString();
    }
}
