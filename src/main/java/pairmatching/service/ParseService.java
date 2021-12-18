package pairmatching.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.WoowaCourse;

public class ParseService {

	private static final Pattern WOOWA_PATTERN = Pattern.compile("(?<course>.+) ,(?<level>.+) ,(?<mission>.+)");
	private static final String YES = "네";

	public WoowaCourse parseWoowaCourse(String input) {
		Matcher matcher = WOOWA_PATTERN.matcher(input);
		if (!matcher.find()) {
			throw new IllegalArgumentException("과정, 레벨, 미션의 입력이 잘못되었습니다.");
		}
		return new WoowaCourse(
			Course.of(matcher.group("course")),
			Level.of(matcher.group("level")),
			new Mission(matcher.group("mission"))
		);
	}

	public boolean parseRematch(String rematch) {
		return YES.equals(rematch);
	}
}
