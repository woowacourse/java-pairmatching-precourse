package pairmatching.domain;

import java.util.List;

import pairmatching.utils.FileManager;

public class PairMachine {
	private static final PairMachine pairMachine = new PairMachine();
	public static final String SRC_MAIN_RESOURCES_BACKEND_CREW_MD = "./src/main/resources/backend-crew.md";
	public static final String SRC_MAIN_RESOURCES_FRONTEND_CREW_MD = "./src/main/resources/frontend-crew.md";
	private List<Crew> backendCrews;
	private List<Crew> frontendCrews;
	private String selectedCourse;
	private String selectedLevel;
	private String selectedMission;

	private PairMachine() {
	}

	public void init() {
		this.backendCrews = FileManager.loadCrewFromFile(SRC_MAIN_RESOURCES_BACKEND_CREW_MD);
		this.frontendCrews = FileManager.loadCrewFromFile(SRC_MAIN_RESOURCES_FRONTEND_CREW_MD);

		selectedCourse = null;
		selectedLevel = null;
		selectedMission = null;
	}

	public static PairMachine getInstance() {
		return pairMachine;
	}

	public void insertMatchingInfo(List<String> matchingInfo) {
		this.selectedCourse = matchingInfo.get(0);
		this.selectedLevel = matchingInfo.get(1);
		this.selectedMission = matchingInfo.get(2);
	}
}
