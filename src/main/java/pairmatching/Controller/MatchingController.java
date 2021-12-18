package pairmatching.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.Domain.Course;
import pairmatching.Domain.Crew;
import pairmatching.Domain.Level;
import pairmatching.Domain.Mission;
import pairmatching.Domain.MissionRepository;
import pairmatching.Util.CrewInfoReader;
import pairmatching.Util.ParsingString;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class MatchingController {

	private static final int REQUEST_INFO_COURSE = 0;
	private static final int REQUEST_INFO_LEVEL = 1;
	private static final int REQUEST_INFO_MISSION_NAME = 2;

	private HashMap<String, Crew> crewHashMap = new HashMap<>();
	private List<String> backendCrewNameList = new ArrayList<>();
	private List<String> frontendCrewNameList = new ArrayList<>();
	private List<Mission> missionList;
	private boolean exitChecker = true;
	private int recordChecker = 0;

	public void ready() {
		registerCrew();
		missionList = MissionRepository.missionList();
	}

	public void matchingProgram() {
		String requestFunction = InputView.requestFunction();
		findFunction(requestFunction);
	}

	public void registerCrew() {
		List<Crew> backendCrewList = CrewInfoReader.getBackendCrewInfo();
		List<Crew> frontendCrewList = CrewInfoReader.getFrontendCrewInfo();
		this.backendCrewNameList = new ArrayList<>();
		for (Crew crew : backendCrewList) {
			this.backendCrewNameList.add(crew.getName());
			crewHashMap.put(crew.getName(), crew);
		}
		this.frontendCrewNameList = new ArrayList<>();
		for (Crew crew : frontendCrewList) {
			this.frontendCrewNameList.add(crew.getName());
			crewHashMap.put(crew.getName(), crew);
		}
	}

	public void findFunction(String input) {
		if (input.equals("1")) {
			pairMatch();
		}
		if (input.equals("2")) {
			inquireMatchInfo();
		}
		if (input.equals("3")) {
			resetMatchInfo();
		}
		if (input.equals("Q")) {
			matchExit();
		}
	}

	public void pairMatch() {
		OutputView.printProgramInfo(this.missionList);
		Mission mission;
		List<String> splitRequestInfo;
		do {
			String userReqeustInfo = InputView.requestMatchInfo();
			splitRequestInfo = ParsingString.splitComma(userReqeustInfo);
			mission = findMission(splitRequestInfo.get(REQUEST_INFO_MISSION_NAME));
		} while (existPair(mission));
		List<String> shuffleNameList = shuffleNameList(splitRequestInfo);
		OutputView.printPairResult(shuffleNameList);
	}

	public void inquireMatchInfo() {
		OutputView.printProgramInfo(this.missionList);
		String userReqeustInfo = InputView.requestMatchInfo();
		List<String> splitRequestInfo = ParsingString.splitComma(userReqeustInfo);
	}

	public void resetMatchInfo() {

	}

	public void matchExit() {
		this.exitChecker = false;
	}

	public Mission findMission(String input) {
		return this.missionList.stream().findFirst().filter(mission -> mission.getName().equals(input)).orElse(null);
		//null일 경우 미션이 존재하지 않는다는 에러 발생시키기
	}

	public boolean existPair(Mission mission) {
		if (mission.existPair()) {
			OutputView.printExistPair();
			String rematchInfo = InputView.requestRematch();
			return rematchInfo.equals("아니오");
		}
		return false;
	}

	public List<String> shuffleNameList(List<String> input) {
		if (input.get(REQUEST_INFO_COURSE).equals(Course.BACKEND.getName())) {
			return Randoms.shuffle(this.backendCrewNameList);
		}
		return Randoms.shuffle(this.frontendCrewNameList);
	}

	public void existRecord() {
		recordChecker += 1;
		if (recordChecker == 3) {
			OutputView.printThreeTimeError();
			throw new IllegalArgumentException("3회 이상 매칭 실패.");
		}
		throw new IllegalArgumentException("이미 매칭된 기록이 있는 크루입니다.");
	}
}
