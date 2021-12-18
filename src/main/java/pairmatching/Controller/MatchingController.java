package pairmatching.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pairmatching.Domain.Crew;
import pairmatching.Domain.Mission;
import pairmatching.Domain.MissionRepository;
import pairmatching.Util.CrewInfoReader;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class MatchingController {

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
	}

	public void inquireMatchInfo() {
		OutputView.printProgramInfo(this.missionList);
	}

	public void resetMatchInfo() {

	}

	public void matchExit() {
		this.exitChecker = false;
	}

}
