package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String printIndex() {
        emptyLine();
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        return readLine();
    }

    private static String readLine() {
        return Console.readLine().replace(" ", "");
    }

    private static void emptyLine() {
        System.out.println();
    }

    public static String printProcessLevelMissionSelection() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        return readLine();
    }

    public static String printRematching() {
        emptyLine();
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
        return readLine();
    }
}
