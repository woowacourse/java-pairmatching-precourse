package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class Utils {
    public static void InputStartMenu() {
        String answer = Console.readLine();
        Utils.SelectFunction(answer);
    }

    public static void SelectFunction(String answer) {
        if (answer.equals("1")) {
            PrintPage.PairMatching();
        }
        if (answer.equals("2")) {
            // 페어 조회
        }
        if (answer.equals("3")) {
            // 페어 초기화
        }
        if (!(answer.equals("1")||answer.equals("2")||answer.equals("3")||answer.equals("Q"))) {
            Except.StartPageError();
        }
    }

    public static void InputPairMatching() {
        String[] answer = Console.readLine().split(", ");

    }
}
