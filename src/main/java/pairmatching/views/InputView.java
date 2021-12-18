package pairmatching.views;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constants.InputConstants;

public class InputView {
    public static String getFunction() {
        System.out.println("기능을 선택하세요.");
        System.out.println(InputConstants.PAIR_MATCHING + ". 페어 매칭");
        System.out.println(InputConstants.PAIR_SEARCHING + ". 페어 조회");
        System.out.println(InputConstants.PAIR_CLEAR + ". 페어 초기화");
        System.out.println(InputConstants.PAIR_QUIT + ". 종료");

        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private static void validateInput(String input) {
        if(!InputConstants.INPUT.contains(input)) {
            throw new IllegalArgumentException("[ERROR] : 해당하는 기능이 없습니다.");
        }
    }

}
