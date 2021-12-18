package pairmatching.utils;

public class ExceptionMessage {

	public static final String ERROR = "[ERROR] ";

	public static final String INPUT_FUNCTION = ERROR + "잘못된 입력입니다. 보기를 다시 확인해주세요.";
	public static final String INPUT_LENGTH = ERROR + "구분자 " + Constant.DELIMITER_SELECT + "로 과정,레벨,미션 순서로 입력해주세요";
	public static final String INPUT_COURSE = ERROR + "과정의 이름이 잘못되었습니다.";
	public static final String INPUT_LEVEL = ERROR + "레벨의 이름이 잘못되었습니다.";
	public static final String INPUT_MISSION = ERROR + "미션의 이름이 잘못되었습니다.";

	// 매칭
	public static final String MATCING_FAIL = ERROR + "매칭에 실패하였습니다."; // 3회 시도까지 매칭x, 경우의 수 없음
	public static final String HISTORY_NULL = ERROR + "매칭 이력이 없습니다.";

}
