package pairmatching.constant.message;

import pairmatching.constant.Course;
import pairmatching.constant.Level;

public class SystemMessage {

	public static final String NEWLINE = System.getProperty("line.separator");

	public static final String INPUT_ENTRY_MENU = "기능을 선택하세요." + NEWLINE
		+ "1. 페어 매칭" + NEWLINE
		+ "2. 페어 조회" + NEWLINE
		+ "3. 페어 초기화" + NEWLINE
		+ "Q. 종료";

	public static final String SHARP_LINE = "#############################################" + NEWLINE;
	public static final String INPUT_COURSE_MENU =
		SHARP_LINE + "과정: " + Course.getSelfDescription() + NEWLINE
			+ "미션:" + NEWLINE
			+ Level.getSelfDescription()
			+ SHARP_LINE
			+ "과정, 레벨, 미션을 선택하세요." + NEWLINE
			+ "ex) 백엔드, 레벨1, 자동차경주";

	public static final String QUIT = "Q";

	public static final String INVALID_COURSE = "존재하지 않는 과정입니다.";
}
