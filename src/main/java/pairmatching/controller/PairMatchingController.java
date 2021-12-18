package pairmatching.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class PairMatchingController {
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final String DELIMITER = ",";
	private static final String FRONTEND_COURSE = "프론트엔드";
	private static final String BACKEND_COURSE = "백엔드";
	private static Map<Crew, ArrayList<Crew>> pair;
	private static Set<String> pairHistory = new HashSet<>();

	private final InputView inputView;

	public PairMatchingController() {
		inputView = new InputView(new Scanner(System.in));
	}

	public String scanFunctionNumber() {
		return inputView.scanFunctionNumber();
	}

	public void matchFunction(int functionNumber) {
		if (functionNumber == ONE) {
			String[] courseAndLevelAndMission = inputView.scanCourseAndLevelAndMission().trim().split(DELIMITER);

			if (pairHistory.contains(courseAndLevelAndMission[0] + courseAndLevelAndMission[1])) {
				courseAndLevelAndMission = isRematch(courseAndLevelAndMission);
			}

			pairHistory.add(courseAndLevelAndMission[0] + courseAndLevelAndMission[1]);
			String course = courseAndLevelAndMission[0];
			if (course.equals(FRONTEND_COURSE)) {
				matchPair(Course.FRONTEND);
			}
			if (course.equals(BACKEND_COURSE)) {
				matchPair(Course.BACKEND);
			}
			OutputView.printPairResult(pair);
		}

		if (functionNumber == TWO) {
			String[] courseAndLevelAndMission = inputView.scanCourseAndLevelAndMission().trim().split(DELIMITER);
			if (pairHistory.contains(courseAndLevelAndMission[0] + courseAndLevelAndMission[1])) {
				OutputView.printPairResult(pair);
				return;
			}
			OutputView.printErrorNotMathcingHistory();
		}
	}

	public void matchPair(Course course) {
		List<String> crewNames = readCrewNames(course);
		List<String> shuffledCrew = Randoms.shuffle(crewNames);
		int crewSize = shuffledCrew.size();

		// 페어 매칭
		pair = new LinkedHashMap<>();
		for (int i = 0; i < crewSize - 1; i += 2) {
			Crew crew1 = new Crew(course, shuffledCrew.get(i));
			Crew crew2 = new Crew(course, shuffledCrew.get(i + 1));
			if (!pair.containsKey(crew1)) {
				pair.put(crew1, new ArrayList<>());
				pair.get(crew1).add(crew2);
			}
			if ((crewSize % 2 == 1) && (i == crewSize - 3)) {
				pair.get(crew1).add(new Crew(course, shuffledCrew.get(crewSize - 1)));
			}
		}
	}

	public List<String> readCrewNames(Course course) {
		List<String> crewNames = new ArrayList<>();
		try {
			File file = null;
			if (course == Course.FRONTEND) {
				file = new File(getClass().getResource("/frontend-crew.md").toURI());
			}
			if (course == Course.BACKEND) {
				file = new File(getClass().getResource("/backend-crew.md").toURI());
			}
			BufferedReader br = new BufferedReader(new FileReader(file));
			String crewName;
			while ((crewName = br.readLine()) != null) {
				crewNames.add(crewName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return crewNames;
	}

	public String[] isRematch(String[] courseAndLevelAndMission) {
		if (inputView.scanIsRematch().equals("네")) {
			return courseAndLevelAndMission;
		}
		return inputView.scanCourseAndLevelAndMission().trim().split(DELIMITER);
	}
}
