package pairmatching.controller;

import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.exception.DuplicatedCrewNameException;
import pairmatching.exception.NotFoundFunctionOptionException;
import pairmatching.model.Course;
import pairmatching.model.CrewNameReader;
import pairmatching.model.CrewRepository;
import pairmatching.model.FunctionOption;
import pairmatching.model.Level;
import pairmatching.model.MatchResults;
import pairmatching.model.Mission;
import pairmatching.model.MissionReader;
import pairmatching.model.MissionRepository;
import pairmatching.view.InputView;

public class CrewMatchingController {
	public static final String DELIMITER_FOR_MATCH_REQUEST = ", ";
	public static final String INFO_MESSAGE_IF_WANT_TO_REMATCH = "\n매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오\n";
	private CrewRepository frontendCrews;
	private CrewRepository backendCrews;
	private MissionRepository missions;
	private MatchResults matchResults = new MatchResults();

	public void start() {
		setupCrewInfo();
		setupMissionInfo();
		boolean isRunning = true;

		while (isRunning) {
			InputView.printFunctionOptions();
			FunctionOption functionOptionFromClient = getFunctionOptionFromClient();
			isRunning = operateByFunction(functionOptionFromClient, isRunning);
		}
	}

	private void setupMissionInfo() {
		List<String> strings = MissionReader.readMissionString();
		this.missions = new MissionRepository(strings);
	}

	private boolean operateByFunction(FunctionOption functionOptionFromClient, boolean isRunning) {
		if (functionOptionFromClient.equals(FunctionOption.EXIT)) {
			return false;
		}

		if (functionOptionFromClient.equals(FunctionOption.MATCH)) {
			InputView.printCourseInfo();
			matchProcess();
		} else if (functionOptionFromClient.equals(FunctionOption.READ)) {
			InputView.printCourseInfo();
			String courseAndMissionInput = InputView.getCourseAndMissionInput(missions);
			Mission mission = getMissionByCourseInput(courseAndMissionInput);
			System.out.println(matchResults.getMatchResultByMission(mission));
		} else if (functionOptionFromClient.equals(FunctionOption.RESET)) {
			matchResults.reset();
		}

		return true;
	}

	private void matchProcess() {
		String courseAndMissionInput = InputView.getCourseAndMissionInput(missions);
		if (hasMatchResult(courseAndMissionInput)) {
			rematchProcess(courseAndMissionInput);
		} else if (!hasMatchResult(courseAndMissionInput)) {
			matchByRequest(courseAndMissionInput);
		}
	}

	private void rematchProcess(String courseAndMissionInput) {
		System.out.println(INFO_MESSAGE_IF_WANT_TO_REMATCH);
		String s = Console.readLine();
		if (Objects.equals(s, "네")) {
			matchResults.resetMatchResultByMission(getMissionByCourseInput(courseAndMissionInput));
			matchByRequest(courseAndMissionInput);
		} else if (!Objects.equals(s, "네")) {
			matchProcess();
		}
	}

	private Mission getMissionByCourseInput(String courseInput) {
		String[] matchRequest = courseInput.split(DELIMITER_FOR_MATCH_REQUEST);
		Level level = Level.of(matchRequest[1]);
		String missionName = matchRequest[2];
		return missions.getMissionByLevelAndName(level, missionName);
	}

	private boolean hasMatchResult(String courseAndMissionInput) {
		String[] matchRequest = courseAndMissionInput.split(DELIMITER_FOR_MATCH_REQUEST);
		Course course = Course.of(matchRequest[0]);
		Level level = Level.of(matchRequest[1]);
		String missionName = matchRequest[2];
		Mission mission = missions.getMissionByLevelAndName(level, missionName);

		return matchResults.hasMatchResultsByMission(course, mission);
	}

	private void matchByRequest(String courseAndMissionInput) {
		System.out.println("\n페어 매칭 결과입니다.");

		String[] matchRequest = courseAndMissionInput.split(DELIMITER_FOR_MATCH_REQUEST);
		CrewRepository crewsByString = getCrewsByString(matchRequest[0]);
		Level level = Level.of(matchRequest[1]);
		String missionName = matchRequest[2];
		Mission mission = missions.getMissionByLevelAndName(level, missionName);

		matchResults.match(crewsByString, mission, 0);

		System.out.println(matchResults.getMatchResultByMission(mission));
	}

	private CrewRepository getCrewsByString(String crew) {
		if (Objects.equals(crew, "프론트엔드")) {
			return this.frontendCrews;
		}

		return this.backendCrews;
	}

	private FunctionOption getFunctionOptionFromClient() {
		try {
			return FunctionOption.of(Console.readLine());
		} catch (NotFoundFunctionOptionException e) {
			System.out.println(e.getMessage());
			return getFunctionOptionFromClient();
		}
	}

	private void setupCrewInfo() {
		try {
			frontendCrews = new CrewRepository(CrewNameReader.getFrontendCrewNameList());
			backendCrews = new CrewRepository(CrewNameReader.getBackendCrewNameList());
		} catch (DuplicatedCrewNameException e) {
			System.out.println(e.getMessage());
		}
	}
}
