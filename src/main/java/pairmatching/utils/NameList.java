package pairmatching.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.models.Course;

public class NameList {

	private final static String COMMON_PATH = "/src/main/resources";

	private final static String BACKEND_CREW_PATH = "/backend-crew.md";

	private final static String FRONTEND_CREW_PATH = "/frontend-crew.md";

	private String makePath(final String course) {
		final String absolutePath = (new File("")).getAbsolutePath();
		if(course.equals(Course.BACKEND.getName())) {
			return absolutePath + COMMON_PATH + BACKEND_CREW_PATH;
		}
		return absolutePath + COMMON_PATH + FRONTEND_CREW_PATH;
	}

	private List<String> readName(final String course) throws IOException {
		final String filePath = makePath(course);
		final List<String> names = new ArrayList<>();
		BufferedReader readFile = new BufferedReader(new FileReader(filePath));
		while(true) {
			String name = readFile.readLine();
			if(name == null) break;
			names.add(name);
		}
		readFile.close();
		return names;
	}

	public List<String> shuffleName(final String course) throws IOException {
		final List<String> names = readName(course);
		return Randoms.shuffle(names);
	}

}
