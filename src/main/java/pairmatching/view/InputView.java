package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class InputView {

    public static final String CHOOSE_FUNCTION_BUTTON = "기능을 선택하세요.";
    public static final String PAIR_MATCHING_BUTTON = "\n1. 페어 매칭";
    public static final String LOOK_PAIR_BUTTON = "\n2. 페어 조회";
    public static final String INITIALIZE_BUTTON = "\n3. 페어 초기화";
    public static final String QUIT_BUTTON = "\nQ. 종료";
    public static final String CHOOSE_ONE = "1";
    public static final String CHOOSE_TWO = "2";
    public static final String CHOOSE_THREE = "3";
    public static final String CHOOSE_Q = "Q";
    public static final String DIVIDING_LINE = "\n#############################################";
    public static final String INDENT_NEW_LINE = "  \n";
    public static final String NEW_LINE = "\n";

    public static String startFunction() {
        try {
            System.out.println(CHOOSE_FUNCTION_BUTTON + PAIR_MATCHING_BUTTON + LOOK_PAIR_BUTTON + INITIALIZE_BUTTON + QUIT_BUTTON);

            return validateStartFunction(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());

            return startFunction();
        }
    }

    private static String validateStartFunction(String readLine) {
        if (!readLine.equals(CHOOSE_ONE) && !readLine.equals(CHOOSE_TWO) && !readLine.equals(CHOOSE_THREE) && !readLine.equals(CHOOSE_Q)) {
            throw new IllegalArgumentException("[ERROR] 기능 목록 중 하나를 선택하세요.");
        }

        return readLine;
    }

    public static String chooseNumberOne() {
        String stringBuilder = DIVIDING_LINE + "\n과정: 백엔드 | 프론트엔드" + "\n미션:" +
                INDENT_NEW_LINE + "- 레벨1: 자동차경주 | 로또 | 숫자야구게임" + INDENT_NEW_LINE +
                "- 레벨2: 장바구니 | 결제 | 지하철노선도" + INDENT_NEW_LINE + "- 레벨3: " + NEW_LINE + "\t" +
                "- 레벨4: 성능개선 | 배포" + INDENT_NEW_LINE + "- 레벨5: " + DIVIDING_LINE +
                "\n과정, 레벨, 미션을 선택하세요.";
        System.out.println(stringBuilder);

        return Console.readLine();
    }

    public static String chooseWhat(String readLine) {
//        if (readLine.equals(CHOOSE_ONE)) {
//            chooseNumberOne();
//        }
//        if (readLine.equals(CHOOSE_TWO)) {
//            chooseNumberTwo();
//        }
//        if (readLine.equals(CHOOSE_THREE)) {
//            chooseNumberThree();
//        }
//        if (readLine.equals(CHOOSE_Q)) {
//            quitProgram();
//        }
        return chooseNumberOne();
    }

    public static List<String> splitInformation(String userInput) {
        String[] splitProgram = userInput.split(",");

        return new ArrayList<>(Arrays.asList(splitProgram));
    }
}
