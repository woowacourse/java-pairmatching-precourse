package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class Utils {
    public static void InputStartMenu() {
        String answer = Console.readLine();
        Utils.SelectFunction(answer);
    }

    public static void SelectFunction(String answer) {
        if (answer.equals("1")) {
            // 페어 매칭
        }
        if (answer.equals("1")) {
            // 페어 조회
        }
        if (answer.equals("1")) {
            // 페어 초기화
        }
        if (answer.equals("1")) {
            // 종료
        }
        Except.StartPageError();
    }
}
