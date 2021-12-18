package pairmatching.domains.mission;

import static pairmatching.constant.ErrorMessages.*;
import static pairmatching.constant.ViewMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domains.crew.Crew;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static String getCourseView() {
		String form = COURSE_PREFIX;
		return form +
			Arrays.stream(Course.values())
			.map(c -> c.name)
			.collect(Collectors.joining(STATE_DIVIDER));
	}

	public static Course findByString(String course) {
		return Arrays.stream(Course.values())
			.filter(s -> s.name.equals(course))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(
				COURSE_NULL + LINE_BREAK
			));
	}

}
