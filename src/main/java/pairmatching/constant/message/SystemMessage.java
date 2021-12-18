package pairmatching.constant.message;

import static pairmatching.constant.Course.*;

import pairmatching.constant.Course;
import pairmatching.constant.Level;

public class SystemMessage {
	public static final String INPUT_ENTRY_MENU = "기능을 선택하세요.\n"
		+ "1. 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료";

	public static final String LINE = "#############################################\n";
	public static final String INPUT_COURSE_MENU =
		LINE + "과정: " + Course.getSelfDescription() + "\n"
			+ "미션:\n"
			+ Level.getSelfDescription()
			+ LINE
			+ "과정, 레벨, 미션을 선택하세요.";
}
