package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;

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
    private Course course;
    private Level level;
    private Mission mission;

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
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(DIVIDING_LINE).append("\n과정: 백엔드 | 프론트엔드").append("\n미션:")
                .append(INDENT_NEW_LINE).append("- 레벨1: 자동차경주 | 로또 | 숫자야구게임").append(INDENT_NEW_LINE)
                .append("- 레벨2: 장바구니 | 결제 | 지하철노선도").append(INDENT_NEW_LINE).append("- 레벨3: ").append(NEW_LINE).append("\t")
                .append("- 레벨4: 성능개선 | 배포").append(INDENT_NEW_LINE).append("- 레벨5: ").append(DIVIDING_LINE)
                .append("\n과정, 레벨, 미션을 선택하세요.");
        System.out.println(stringBuilder);

        return Console.readLine();
    }

    public static String chooseWhat(String readLine) {
        if (readLine.equals(CHOOSE_ONE)) {
            chooseNumberOne();
        }
//        if (readLine.equals(CHOOSE_TWO)) {
//            chooseNumberTwo();
//        }
//        if (readLine.equals(CHOOSE_THREE)) {
//            chooseNumberTwo();
//        }
//        if (readLine.equals(CHOOSE_Q)) {
//            quitProgram();
//        }
        return readLine;
    }

    public static List<String> FindProgramList(String userInput) {
        String[] splitProgram = userInput.split(",");

        return new ArrayList<>(Arrays.asList(splitProgram));

    }
}
