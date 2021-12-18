package pairmatching.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constant {
	public static final String BACKEND_CREW_FILE_LOCATION = "src/main/resources/backend-crew.md";
	public static final String FRONTEND_CREW_FILE_LOCATION = "src/main/resources/frontend-crew.md";

	public static final String START = "PLZ_DO_IT_AGAIN";
	public static final String AGAIN = "PLZ_DO_IT_AGAIN";
	public static final String EXIT = "EXIT";

	public static final String SELECT_PAIR_MATCHING = "1";
	public static final String SELECT_PAIR_SEARCH = "2";
	public static final String SELECT_PAIR_RESET = "3";
	public static final String SELECT_PAIR_QUIT = "Q";

	public static final String FUNCTION_PAIR_MATCHING = "1";
	public static final String FUNCTION_PAIR_FIND = "2";
	public static final String FUNCTION_PAIR_RESET = "3";
	public static final String FUNCTION_PAIR_QUIT = "Q";
	public static final List<String> FUNCTION_SELECT_LIST = Arrays.asList(
			FUNCTION_PAIR_MATCHING,
			FUNCTION_PAIR_FIND,
			FUNCTION_PAIR_RESET,
			FUNCTION_PAIR_QUIT

	);

	public static final String FRONTEND = "FRONT";
	public static final String BACKEND = "BACK";
	public static final List<String> NOT_FOUNDED = new ArrayList<>();
	public static final List<String> NOT_EXISTED = new ArrayList<>();

	public static final String SPACE = " ";

	public static final String VALID_FORMAT = "(^[a-zA-Z가-힣0-9]{1,10}),([a-zA-Z가-힣0-9]{1,10}),([a-zA-Z가-힣0-9]{1,10}$)";
	public static final String SPLIT = ",";

	public static final String FRONTEND_COURSE = "프론트엔드";
	public static final String BACKEND_COURSE = "백엔드";
	public static final List<String> COURSE = Arrays.asList(
			BACKEND_COURSE,
			FRONTEND_COURSE
	);

	public static final String LEVEL_1_LABEL = "레벨1";
	public static final String LEVEL_2_LABEL = "레벨2";
	public static final String LEVEL_3_LABEL = "레벨3";
	public static final String LEVEL_4_LABEL = "레벨4";
	public static final String LEVEL_5_LABEL = "레벨5";
	public static final List<String> LEVEL_LABELS = Arrays.asList(
			LEVEL_1_LABEL,
			LEVEL_2_LABEL,
			LEVEL_3_LABEL,
			LEVEL_4_LABEL,
			LEVEL_5_LABEL
	);

	public static final int COURSE_INFO = 0;
	public static final int LEVEL_INFO = 1;
	public static final int MISSION_INFO = 2;

	// === Mission Constant === //
	public static final String LEVEL_1_MISSION_RACING = "자동차경주";
	public static final String LEVEL_1_MISSION_LOTTO = "로또";
	public static final String LEVEL_1_MISSION_BASEBALL = "숫자야구게임";
	public static final List<String> LEVEL_1 = Arrays.asList(
			LEVEL_1_MISSION_RACING,
			LEVEL_1_MISSION_LOTTO,
			LEVEL_1_MISSION_BASEBALL
	);

	public static final String LEVEL_2_MISSION_BUCKET = "장바구니";
	public static final String LEVEL_2_MISSION_PAYMENT = "결제";
	public static final String LEVEL_2_MISSION_SUBWAY_MAP = "지하철노선도";
	public static final List<String> LEVEL_2 = Arrays.asList(
			LEVEL_2_MISSION_BUCKET,
			LEVEL_2_MISSION_PAYMENT,
			LEVEL_2_MISSION_SUBWAY_MAP
	);

	public static final String EMPTY = "";
	public static final List<String> LEVEL_3 = Arrays.asList(EMPTY);
	public static final List<String> LEVEL_5 = Arrays.asList(EMPTY);

	public static final String LEVEL_4_MISSION_REFACTORING = "성능개선";
	public static final String LEVEL_4_MISSION_DEPLOY = "배포";
	public static final List<String> LEVEL_4 = Arrays.asList(
			LEVEL_4_MISSION_REFACTORING,
			LEVEL_4_MISSION_DEPLOY
	);

	public static final int SHOW_TWO = 2;
	public static final int SHOW_THREE = 3;

	public static final List<List<String>> MISSION = Arrays.asList();

	private Constant() {

	}
}
