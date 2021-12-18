package pairmatching.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Constants {
    // public static final String
    public static final String BACKEND_CREW_DIR = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_CREW_DIR ="src/main/resources/frontend-crew.md";

    public static final String FUNCTION_MAIN = "기능을 선택하세요.";
    public static final String FUNCTION_1 = "1. 페어 매칭";
    public static final String FUNCTION_2 = "2. 페어 조회";
    public static final String FUNCTION_3 = "3. 페어 초기화";
    public static final String FUNCTION_Q = "Q. 종료";

    public static final String FAIR_MATCHING_OPT = "1";
    public static final String FAIR_LOOKUP_OPT = "2";
    public static final String FAIR_INIT_OPT = "3";

    public static final String MENU_DELIMETER = "#############################################";
    public static final String MENU_COURSES = "과정: 백엔드 | 프론트엔드";
    public static final String MENU_MISSION = "미션:";
    public static final String LEVEL_1 = "- 레벨1: 자동차경주 | 로또 | 숫자야구게임";
    public static final String LEVEL_2 = "- 레벨2: 장바구니 | 결제 | 지하철노선도";
    public static final String LEVEL_3 = "- 레벨3: ";
    public static final String LEVEL_4 = "- 레벨4: 성능개선 | 배포";
    public static final String LEVEL_5 = "- 레벨5: ";

    public static final String SELECT_C_L_M = "과정, 레벨, 미션을 선택하세요.";
    public static final String EX_C_L_M = "ex) 백엔드, 레벨1, 자동차경주";

    public static final String FAIR_MATCHING_RESULT_MSG = "페어 매칭 결과입니다.";
    public static final String FAIR_DELIMETER = " : ";

    public static final String ASK_REMATCHING_MSG = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    public static final String REMATCHING_OPTION_MSG = "네 | 아니오";

    public static final String CLM_PATTERN = "(\\w+), (\\w+), (\\w+)";
    public static final String FUNCTION_PATTERN = "[123Q]";

    public static final String EXIT_MSG = "프로그램을 종료합니다.";

    public static final String ERROR = "[ERROR] ";
    public static final String WRONG_FUNCTION_PATTERN = "잘못된 기능을 선택하셨습니다.";
    public static final String WRONG_CLM_PATTERN = "잘못된 과정, 레벨, 미션을 입력하셨습니다.";

    public static final List<String> COURSES = new ArrayList<>(
        Arrays.asList(
            "백엔드", "프론트엔드")
    );
    public static final List<String> LEVELS = new ArrayList<>(
        Arrays.asList(
            "레벨1", "레벨2", "레벨3", "레벨4", "레벨5"
        )
    );
    public static final HashMap<String, List<String>> MISSIONS = new HashMap() {
        {
            put("레벨1", new ArrayList<>(Arrays.asList("자동차경주", "로또", "숫자야구게임")));
            put("레벨2", new ArrayList<>(Arrays.asList("장바구니", "결제", "지하철노선도")));
            put("레벨3", Collections.emptyList());
            put("레벨4", new ArrayList<>(Arrays.asList("성능개선", "배포")));
            put("레벨5", Collections.emptyList());
        }
    };
}
