package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String startFunction() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("기능을 선택하세요.")
                .append("\n1. 페어 매칭")
                .append("\n2. 페어 조회")
                .append("\n3. 페어 초기화")
                .append("\nQ. 종료");
        System.out.println(stringBuilder);
        return Console.readLine();
    }
}
