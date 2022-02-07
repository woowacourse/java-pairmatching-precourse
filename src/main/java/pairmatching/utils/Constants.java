package pairmatching.utils;

import java.util.regex.Pattern;

public class Constants {
	// 단위 상수
	public static final String CONSTANT = "상수";

	// 정규식
	// 사이트: https://regexr.com/5mhou
	public static final String REGEX = "^[123Q]$";
	public static final Pattern PATTERN = Pattern.compile(REGEX);

	// 오류메세지 관련 상수
	public static final String ERROR = "[ERROR] ";
	public static final String ERROR_MAIN_PATTERN = ERROR + "1,2,3,Q중 하나를 입력해야 한다.";
	public static final Pattern MISSION_PATTERN = Pattern.compile("^[가-힣]+, [가-힣1-5]+, [가-힣]+$");
	public static final String ERROR_MISSION_PATTERN = "형식을 지켜야 한다.";
	public static final String BACKEND = "백엔드";
	public static final String FRONTEND = "프론트엔드";
}
