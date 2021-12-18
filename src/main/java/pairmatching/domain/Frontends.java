package pairmatching.domain;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.common.Course;
import pairmatching.utils.ReadFile;

public class Frontends {
	private static List<String> crews;

	public static void initialize (Course course) throws IOException {
		crews = ReadFile.readCrewNameList(course);

	}

	public static List<String> getCrews () {
		return crews;
	}
}