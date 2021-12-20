package pairmatching.constant;

public class ExceptionMessage {
	private static final String PREFIX = "[ERROR] ";

	public static final String INVALID_LEVEL = PREFIX + "잘못된 레벨입니다";
	public static final String INVALID_COURSE = PREFIX + "잘못된 코스입니다";
	public static final String INVALID_MISSION_NAME = PREFIX + "잘못된 미션 이름입니다";
	public static final String INVALID_CREW = PREFIX + "잘못된 크루 이름입니다";
	public static final String MATCHING_FAIL_FINALLY = PREFIX + "매칭에 실패했습니다. 메인으로 돌아갑니다";
	public static final String MATCHING_FAIL = PREFIX + "매칭에 실패했습니다";
	public static final String CREW_READ_FAIL_NOT_FOUND = PREFIX + "파일을 찾지 못했습니다";
	public static final String CREW_READ_FAIL_INACCESSIBLE = PREFIX + "파일을 찾지 못했습니다";
	public static final String MATCHING_NOT_FOUND = PREFIX + "매칭이 없습니다";
}
