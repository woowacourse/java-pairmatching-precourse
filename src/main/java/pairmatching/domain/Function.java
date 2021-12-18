package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.unit.Course;
import pairmatching.domain.unit.Level;
import pairmatching.domain.unit.Mission;
import pairmatching.exception.GlobalException;
import pairmatching.view.OutputView;

public class Function {
	private static final int COURSE = 0;
	private static final int LEVEL = 1;
	private static final int MISSION = 2;

	private int number;
	private MatchingSystem matchingSystem;

	public Function() {
		this.matchingSystem = new MatchingSystem();
	}

	public void initNumber(int number) {
		this.number = number;
	}

	public boolean handleFunction(String[] information) throws IOException {
		GlobalException.validateMatchingInformation(information);

		String course = information[COURSE];
		String level = information[LEVEL];
		String mission = information[MISSION];

		if(number == 1) {
			return matching(course,level,mission);

		}

		if(number == 2) {
			check(course,level,mission);
			return true;
		}

		initialize(course,level,mission);
		return true;
	}

	private boolean matching(String course, String level, String mission) throws IOException {
		String filePath = "";
		if(course.equals("백엔드")) {
			filePath = "backend-crew.md";
		}

		if(course.equals("프론트엔드")) {
			filePath = "frontend-crew.md";
		}
		List<String> matchingResult = Randoms.shuffle(getCrewNames(filePath));

		return matchingSystem.save(new Matching(Course.mapToCourse(course), Level.mapToLevel(level), Mission
			.mapToLevel(mission), matchingResult));
	}

	// TODO: utils 로 빼기
	private List<String> getCrewNames(String filePath) throws IOException {
		List<String> crewName = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(
			new FileReader("src/main/resources/"+filePath));

		while(true) {
			String line = bufferedReader.readLine();
			crewName.add(line);
			if(line == null) break;
		}
		bufferedReader.close();

		return crewName;
	}

	private void check(String course, String level, String mission) {
		OutputView.printMatchingResult(matchingSystem.read(new Matching(Course.mapToCourse(course), Level.mapToLevel(level), Mission
			.mapToLevel(mission), new ArrayList<>())));
	}

	private void initialize(String course, String level, String mission) {
		matchingSystem.remove(new Matching(Course.mapToCourse(course), Level.mapToLevel(level), Mission
			.mapToLevel(mission), new ArrayList<>()));

		OutputView.printCompleteInitialize();
	}
}
