package pairmatching.enums;

import static pairmatching.enums.ErrorMessage.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private static final String SEPARATOR = " | ";

	private String name;

	Course(String name) {
		this.name = name;
	}

	public String get() {
		return name;
	}

	public static Course getByValue(String course) {
		for (Course value : Course.values()) {
			if (value.get().equals(course)) {
				return value;
			}
		}
		throw new IllegalArgumentException(COURSE_GET_BY_VALUE_ERROR.get());
	}

	public static String getNamesJoinBar() {
		return Arrays.stream(Course.values())
			.map(Course::get)
			.collect(Collectors.joining(SEPARATOR));
	}

	public List<String> getCrewNames() {
		String crewPath = this.getClass().getClassLoader().getResource("backend-crew.md").getPath();
		if (this.equals(Course.FRONTEND)) {
			crewPath = this.getClass().getClassLoader().getResource("frontend-crew.md").getPath();
		}
		List<String> crewNames = readAndGetName(crewPath);
		return Randoms.shuffle(crewNames);
	}

	private List<String> readAndGetName(String crewPath) {
		List<String> crewNames = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(crewPath));
			String name;
			while ((name = reader.readLine()) != null) {
				crewNames.add(name);
			}
		} catch (IOException e) {
			throw new IllegalArgumentException(NO_FILE_CREW_ERROR.get());
		}
		return crewNames;
	}
}
