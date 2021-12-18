package pairmatching.util;

public class Constants {
	public static final String INPUT_MESSAGE_SELECT_MENU = "기능을 선택하세요.";
	public static final String INPUT_MESSAGE_PROCESS = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";

	public static final String OUTPUT_MESSAGE_PAIR_MATCHING_RESULT = "페어 매칭 결과입니다.";
	public static final String OUTPUT_MESSAGE_INITIALIZATION = "초기화 되었습니다.\n";

	public static final String ERROR_MESSAGE = "[ERROR] ";
	public static final String ERROR_MESSAGE_INPUT_MENU = ERROR_MESSAGE + "주어진 기능 중에 선택하세요.\n";
	public static final String ERROR_MESSAGE_INPUT_PROCESS = ERROR_MESSAGE + "입력한 과정, 레벨, 미션이 목록에 없습니다.\n";
	public static final String ERROR_MESSAGE_IMPOSSIBLE_PAIR_MATCHING = ERROR_MESSAGE + "3회 시도까지 매칭이 되지 않았습니다.\n";

	public static final String FILE_ADDRESS_BACKEND_CREW = "D:\\Program Files (x86)\\IdeaProjects\\woowacourse\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md";

	public static final String PROCESS_OUT_LINE = "#############################################";
	public static final String PROCESS_SEPARATOR = " | ";
	public static final String PROCESS_COURSE = "과정: ";
	public static final String PROCESS_MISSION = "미션: \n";
	public static final String PROCESS_INPUT_SEPARATOR = ", ";
	public static final int PROCESS_LIST_INPUT_SIZE = 3;

	public static final String MENU_PAIR_MATCHING = "1";
	public static final String MENU_PAIR_RETRIEVE = "2";
	public static final String MENU_PAIR_INITIALIZATION = "3";
	public static final String MENU_EXIT = "Q";

	public static final int PAIR_MATCHING_TRIAL_MAX_VALUE = 3;
	public static final String PAIR_MATCHING_SEPARATOR = " : ";
}
