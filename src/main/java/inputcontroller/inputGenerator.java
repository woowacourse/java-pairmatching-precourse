package inputcontroller;

import camp.nextstep.edu.missionutils.Console;

import outputcontroller.ApplicationUI;

public class inputGenerator {

    public static int[] courseTypeInput = new int[3];

    public static char inputFunctionChoice() {
        String inputText;
        while (true) {
            try {
                inputText = Console.readLine();
                inputValidator.isValidFunctionChoice(inputText);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return inputText.charAt(0);
    }

    public static void inputCourseType() {
        ApplicationUI.printCourseType();
        String inputText;
        String[] inputTextParsed;
        while (true) {
            try {
                ApplicationUI.printUIforCourseTypeInput();
                inputText = Console.readLine();
                inputTextParsed = inputText.split(",");
                inputValidator.isValidCourseLevelMission(inputTextParsed);
                registerInput(inputTextParsed);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static void registerInput(String[] inputTextParsed) {
        if (inputTextParsed[0].equals("백엔드")) {
            courseTypeInput[0] = 0;
        }
        if (inputTextParsed[0].equals("프론트엔드")) {
            courseTypeInput[0] = 1;
        }
        registerLevel(inputTextParsed[1].charAt(2));
        registerMission1(inputTextParsed[2]);
        registerMission2(inputTextParsed[2]);
        registerMission3(inputTextParsed[2]);
    }

    public static void registerLevel(char ch) {
        courseTypeInput[1] = ch - '0';
    }

    public static void registerMission1(String text) {
        if (text.equals("자동차경주")) {
            courseTypeInput[2] = 0;
            return;
        }
        if (text.equals("로또")) {
            courseTypeInput[2] = 1;
            return;
        }
        if (text.equals("숫자야구게임")) {
            courseTypeInput[2] = 2;
            return;
        }
    }

    public static void registerMission2(String text) {
        if (text.equals("장바구니")) {
            courseTypeInput[2] = 0;
            return;
        }
        if (text.equals("결제")) {
            courseTypeInput[2] = 1;
            return;
        }
        if (text.equals("지하철노선도")) {
            courseTypeInput[2] = 2;
            return;
        }
    }

    public static void registerMission3(String text) {
        if (text.equals("성능개선")) {
            courseTypeInput[2] = 0;
            return;
        }
        if (text.equals("배포")) {
            courseTypeInput[2] = 1;
            return;
        }
    }
}
