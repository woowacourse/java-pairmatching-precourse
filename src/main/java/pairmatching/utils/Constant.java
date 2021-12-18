package pairmatching.utils;

public class Constant {
    public static final String REQUEST_FUNCTION_INDEX = "기능을 선택하세요.";
    public static final String FUNCTION_LIST = "1. 페어 매칭\n" +
                                                "2. 페어 조회\n" +
                                                "3. 페어 초기화\n" +
                                                "Q. 종료";
    public static final String FUNCTION_INDEX_STRING = "123Q";
    public static final String INPUT_ONLY_INDEX_ERROR_MESSAGE = "[ERROR] 원하는 기능의 인덱스만 입력해주세요.";
    public static final String INPUT_EXIST_FUNCTION_ERROR_MESSAGE = "[ERROR] 원하는 기능의 인덱스만 입력해주세요.";
    public static final String COURSE_AND_MISSION_LIST = "#############################################\n" +
                                                            "과정: 백엔드 | 프론트엔드\n" +
                                                            "미션:\n" +
                                                            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
                                                            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
                                                            "  - 레벨3: \n" +
                                                            "  - 레벨4: 성능개선 | 배포\n" +
                                                            "  - 레벨5: \n" +
                                                            "############################################";
    public static final String REQUEST_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.";
    public static final String SPLIT_BY = ", ";
    public static final String LIST_LENGTH_ERROR_MESSAGE = "[ERROR] 과정, 레벨, 미션을 다시 입력해주세요.";
    public static final String RESET_MESSAGE = "초기화 되었습니다.";

    public static final int INPUT_INDEX_LENGTH = 1;
    public static final int NEED_LIST_LENGTH = 3;
}
