package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String startFunction() {
        try {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("기능을 선택하세요.").append("\n1. 페어 매칭").append("\n2. 페어 조회").append("\n3. 페어 초기화").append("\nQ. 종료");
            System.out.println(stringBuilder);

            return validateStartFunction(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());

            return startFunction();
        }
    }

    private static String validateStartFunction(String readLine) {
        if (!readLine.equals("1") && !readLine.equals("2") && !readLine.equals("3") && !readLine.equals("Q")) {
           throw new IllegalArgumentException("[ERROR] 기능 목록 중 하나를 선택하세요.");
        }

        return readLine;
    }
}
