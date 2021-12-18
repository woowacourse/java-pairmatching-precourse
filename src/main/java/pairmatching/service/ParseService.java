package pairmatching.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.WoowaCourse;

public class ParseService {

	private static final Pattern WOOWA_PATTERN = Pattern.compile("(?<course>.+), (?<level>.+), (?<mission>.+)");
	private static final String YES = "네";
	private static final String NO = "아니오";

	private static final String ERROR_YESNO = "잘못 입력하셨습니다. 네, 아니오 중 선택하세요.";
	private static final String ERROR_WOOWACOURSE = "과정, 레벨, 미션의 입력이 잘못되었습니다.";

	public WoowaCourse parseWoowaCourse(String input) {
		Matcher matcher = getMatcher(input);
		return new WoowaCourse(
			Course.of(matcher.group("course")),
			Level.of(matcher.group("level")),
			Mission.of(matcher.group("mission"))
		);
	}

	private Matcher getMatcher(String input) {
		Matcher matcher = WOOWA_PATTERN.matcher(input);
		if (!matcher.find()) {
			throw new IllegalArgumentException(ERROR_WOOWACOURSE);
		}
		return matcher;
	}

	public boolean parseRematch(String input) {
		if (YES.equals(input)) {
			return true;
		}
		if (NO.equals(input)) {
			return false;
		}
		throw new IllegalArgumentException(ERROR_YESNO);
	}
}
