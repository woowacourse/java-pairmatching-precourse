package pairmatching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringConstants {
    public static final String PAIR_MATCHING_FUNCTION_KEY = "1";
    public static final String PAIR_CHECK_FUNCTION_KEY = "2";
    public static final String PAIR_INITIALIZATION_FUNCTION_KEY = "3";
    public static final String END_FUNCTION_KEY = "Q";
    public static final Set<String> FUNCTION_KEYS = new HashSet<>(Arrays.asList(PAIR_MATCHING_FUNCTION_KEY, PAIR_CHECK_FUNCTION_KEY, PAIR_INITIALIZATION_FUNCTION_KEY, END_FUNCTION_KEY));

    public static final String REQUEST_MESSAGE_ABOUT_FUNCTION_SELECTION = "기능을 선택하세요.";
    public static final String PAIR_MATCHING_FUNCTION = "1. 페어 매칭";
    public static final String PAIR_CHECK_FUNCTION = "2. 페어 조회";
    public static final String PAIR_INITIALIZATION_FUNCTION = "3. 페어 초기화";
    public static final String END_FUNCTION = "Q. 종료";

    public static final String DIVIDING_LINE  = "#############################################";
    public static final String COURSE  = "과정";
    public static final String MISSION  = "미션";
    public static final String DELIMITER = ": ";
    public static final String DELIMITER_BETWEEN_ITEM = " | ";
    public static final String DELIMITER_FOR_LIST_ITEM = "  - ";

    public static final String REQUEST_MESSAGE_ABOUT_PAIR_INFO = "과정, 레벨, 미션을 선택하세요.";
    public static final String EXAMPLE_MESSAGE_ABOUT_PAIR_INFO = "ex) 백엔드, 레벨1, 자동차경주";

    public static final String RESULT_NOTICE_MESSAGE_ABOUT_PAIR = "페어 매칭 결과입니다.";
    public static final String DELIMITER_FOR_PAIR = " : ";

    public static final String PREFIX_OF_ERROR_MESSAGE = "[ERROR] ";
    public static final String ERROR_MESSAGE_ABOUT_FUNCTION_INPUT = "제시된 기능목록에서 선택해주세요";
    public static final String ERROR_MESSAGE_ABOUT_COURSE_INPUT = "올바른 과정 이름을 입력해주세요";
    public static final String ERROR_MESSAGE_ABOUT_LEVEL_INPUT = "올바른 레벨 이름을 입력해주세요";
    public static final String ERROR_MESSAGE_ABOUT_MISSION_INPUT = "올바른 미션 이름을 입력해주세요";
    public static final String ERROR_MESSAGE_ABOUT_WRONG_LEVEL_MISSION_INPUT = "해당 레벨에 해당하는 올바른 미션 이름을 입력해주세요";

    private StringConstants() {
    }
}
