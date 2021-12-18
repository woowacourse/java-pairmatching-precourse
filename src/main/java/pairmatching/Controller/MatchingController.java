package pairmatching.Controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.Domain.Crew;
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

	private List<Crew> backendCrewList;
	private List<Crew> frontendCrewList;
	private List<String> backendCrewNameList = new ArrayList<>();
	private List<String> frontendCrewNameList = new ArrayList<>();
	private List<Mission> missionList;
	private boolean exitChecker = true;

	public void ready() {
		registerCrew();
		missionList = MissionRepository.missionList();
	}

	public void matchingProgram() {
		String requestFunction = InputView.requestFunction();
		findFunction(requestFunction);

	}

	public void registerCrew() {
		this.backendCrewList = CrewInfoReader.getBackendCrewInfo();
		this.frontendCrewList = CrewInfoReader.getFrontendCrewInfo();
		this.backendCrewNameList = new ArrayList<>();
		for (Crew crew : this.backendCrewList) {
			this.backendCrewNameList.add(crew.getName());
		}
		this.frontendCrewNameList = new ArrayList<>();
		for (Crew crew : this.frontendCrewList) {
			this.frontendCrewNameList.add(crew.getName());
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
		do {
			String userReqeustInfo = InputView.requestMatchInfo();
			List<String> splitRequestInfo = ParsingString.splitComma(userReqeustInfo);
			mission = findMission(splitRequestInfo.get(REQUEST_INFO_MISSION_NAME));
		} while(!existPair(mission));
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

}
