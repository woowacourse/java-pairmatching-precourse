package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String startFunction() {
        try {
            System.out.println("기능을 선택하세요." + "\n1. 페어 매칭" + "\n2. 페어 조회" + "\n3. 페어 초기화" + "\nQ. 종료");

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

    public static String chooseNumberOne() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("#############################################").append("\n과정: 백엔드 | 프론트엔드").append("\n미션:")
                .append("\n").append("\t").append("- 레벨1: 자동차경주 | 로또 | 숫자야구게임").append("\n").append("\t")
                .append("- 레벨2: 장바구니 | 결제 | 지하철노선도").append("\n").append("\t").append("- 레벨3: ").append("\n").append("\t")
                .append("- 레벨4: 성능개선 | 배포").append("\n").append("\t").append("- 레벨5: ").append("\n############################################")
                .append("\n과정, 레벨, 미션을 선택하세요.");
        System.out.println(stringBuilder);

        return Console.readLine();
    }

    public static void chooseWhat(String readLine) {
        if (readLine.equals("1")) {
            chooseNumberOne();
        }
//        if (readLine.equals("2")) {
//            chooseNumberTwo();
//        }
//        if (readLine.equals("3")) {
//            chooseNumberTwo();
//        }
//        if (readLine.equals("Q")) {
//            quitProgram();
//        }
    }
}
