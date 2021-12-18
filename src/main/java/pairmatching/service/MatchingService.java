package pairmatching.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Matching;
import pairmatching.domain.Pairs;
import pairmatching.validator.MatchingValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingService {

	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;
	private Matching matching = new Matching();

	public Matching generateRandomMatching(String input) {
		String[] split = input.split(",");
		Course course = Course.getCourse(split[COURSE_INDEX].trim());
		Level level = Level.getLevel(split[LEVEL_INDEX].trim());
		String missionName = split[MISSION_INDEX].trim();
		List<String> shuffledCrew;
		List<String> crewNames = null;
		if (Course.BACKEND.equals(course)) {
			crewNames = readFileBackendNames();
		}
		if (Course.FRONTEND.equals(course)) {
			crewNames = readFileFrontendNames();
		}
		shuffledCrew = Randoms.shuffle(Objects.requireNonNull(crewNames));
		return makeMatching(level, course, shuffledCrew);
	}

	public void getMatchingList() {
		OutputView.printAdvanceInformation();
		String courseAndLevelAndMission = InputView.inputCourseAndLevelAndMission();
		String[] split = courseAndLevelAndMission.split(",");
		Level level = Level.getLevel(split[LEVEL_INDEX].trim());
		MatchingValidator.isExistMatching(level, matching);
		OutputView.printMatchingInfo(matching);

	}

	private Matching makeMatching(Level level, Course course, List<String> shuffledCrew) {
		List<Pairs> pairsList = new ArrayList<>();
		for (int i = 0; i < shuffledCrew.size() - 1; i += 2) {
			Pairs pairs = new Pairs(Crew.generateCrew(course, shuffledCrew.get(i)),
				Crew.generateCrew(course, shuffledCrew.get(i + 1)));
			pairsList.add(pairs);
		}
		if (shuffledCrew.size() % 2 == 1) {
			Pairs pairs = pairsList.get(pairsList.size() - 1);
			pairs.addMoreCrew(Crew.generateCrew(course, shuffledCrew.get(shuffledCrew.size() - 1)));
		}
		MatchingValidator.checkDuplicatedValidation(level, matching);
		matching.add(level, pairsList);
		return matching;
	}

	private List<String> readFileBackendNames() {
		List<String> crewNames = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
				new InputStreamReader(new FileInputStream("src/main/resources/backend-crew.md"),
					StandardCharsets.UTF_8));
			String name;
			while ((name = reader.readLine()) != null) {
				crewNames.add(name);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return crewNames;
	}

	private List<String> readFileFrontendNames() {
		List<String> crewNames = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
				new InputStreamReader(new FileInputStream("src/main/resources/frontend-crew.md"),
					StandardCharsets.UTF_8));
			String name;
			while ((name = reader.readLine()) != null) {
				crewNames.add(name);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return crewNames;
	}

}
