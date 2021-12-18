package pairmatching.view;

import pairmatching.utils.Validator;

public class ConsoleInputView {

    private static final String INPUT_FUNCTION_REQUEST_MESSAGE = "기능을 선택하세요.";
    private static final String INPUT_MATCHING_INFO_REQUEST_MESSAGE = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";
    private static final String INPUT_FUNCTION_INFO_MESSAGE = "\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";

    public static String inputFunction() {
        OutputView.printMessage(INPUT_FUNCTION_REQUEST_MESSAGE);
        OutputView.printMessage(INPUT_FUNCTION_INFO_MESSAGE);

        String input = camp.nextstep.edu.missionutils.Console.readLine();

        return input;
    }

    public static String inputMatchingInfo() {
        OutputView.printCourseLevelMissionInfo();
        OutputView.printMessage(INPUT_MATCHING_INFO_REQUEST_MESSAGE);
        String input;
        try {
            input = camp.nextstep.edu.missionutils.Console.readLine();
            Validator.validateMatchingInfo(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            input = inputMatchingInfo();
        }
        return input;

    }
}
