package pairmatching.Controller;

import java.util.ArrayList;
import java.util.Arrays;
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
		do {
			String requestFunction = InputView.requestFunction();
			findFunction(requestFunction);
		} while(exitChecker);
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
			mission = findMission(splitRequestInfo.get(REQUEST_INFO_MISSION_NAME).trim());
		} while (existPair(mission));
		List<String> shuffleNameList = shuffleNameList(splitRequestInfo);
		missionList.remove(mission);
		mission.setPairList(shuffleNameList);
		missionList.add(mission);
		OutputView.printPairResult(shuffleNameList);
	}

	public void inquireMatchInfo() {
		OutputView.printProgramInfo(this.missionList);
		String userReqeustInfo = InputView.requestMatchInfo();
		List<String> splitRequestInfo = ParsingString.splitComma(userReqeustInfo);
		Mission mission = findMission(splitRequestInfo.get(REQUEST_INFO_MISSION_NAME).trim());
		OutputView.printPairResult(mission.getPairList());
	}

	public void resetMatchInfo() {
		for (int i = 0; i< missionList.size(); i++){
			Mission mission = missionList.get(i);
			missionList.remove(mission);
			mission.setPairList(new ArrayList<>());
			missionList.add(mission);
		}
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
		recordChecker = 0;
		if (input.get(REQUEST_INFO_COURSE).trim().equals(Course.BACKEND.getName())) {
			return backendShuffle(input.get(REQUEST_INFO_LEVEL).trim());
		}
		return frontendShuffle(input.get(REQUEST_INFO_LEVEL).trim());
	}

	public List<String> backendShuffle(String levelInput) {
		List<String> randomCrewList = new ArrayList<>();
		try {
			randomCrewList = Randoms.shuffle(this.backendCrewNameList);
			checkRecord(levelInput.trim(), randomCrewList);
		} catch (Exception e) {
			if (recordChecker != 0 && recordChecker < 3) {
				return backendShuffle(levelInput.trim());
			}
			OutputView.printError(e.getMessage());
		}
		return randomCrewList;
	}

	public List<String> frontendShuffle(String levelInput) {
		List<String> randomCrewList = new ArrayList<>();
		try {
			randomCrewList = Randoms.shuffle(this.frontendCrewNameList);
			checkRecord(levelInput.trim(), randomCrewList);
		} catch (Exception e) {
			if (recordChecker < 3) {
				return backendShuffle(levelInput.trim());
			}
			OutputView.printError(e.getMessage());
		}
		return randomCrewList;
	}

	public void checkRecord(String levelInput, List<String> crewNameList) {
		Level level = Level.findLevel(levelInput.trim());
		oddSizeChecker(level, crewNameList);
		if (crewNameList.size() / 2 != 0) {
			evensizeChecker(level, crewNameList);
		}
	}

	public void oddSizeChecker(Level level, List<String> crewNameList) {
		for (int i = 0; i < crewNameList.size(); i += 2) {
			String firstCrewName = crewNameList.get(i);
			String secondCrewName = crewNameList.get(i + 1);
			Crew firstCrew = crewHashMap.get(firstCrewName);
			if (firstCrew.hasRecord(level, secondCrewName)) {
				existRecord();
			}
		}
	}

	public void evensizeChecker(Level level, List<String> crewNameList) {
		String firstCrewName = crewNameList.get(crewNameList.size() - 3);
		String secondCrewName = crewNameList.get(crewNameList.size() - 2);
		String finalCrewName = crewNameList.get(crewNameList.size() - 1);
		Crew firstCrew = crewHashMap.get(firstCrewName);
		if (firstCrew.hasRecord(level, secondCrewName) || firstCrew.hasRecord(level, finalCrewName)) {
			existRecord();
		}
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
