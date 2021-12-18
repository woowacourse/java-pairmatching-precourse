package pairmatching.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pairmatching.Domain.Crew;
import pairmatching.Util.CrewInfoReader;

public class MatchingController {

	private List<Crew> backendCrewList;
	private List<Crew> frontendCrewList;
	private List<String> backendCrewNameList;
	private List<String> frontendCrewNameList;

	public void ready() {
		registerCrew();
	}

	public void registerCrew() {
		this.backendCrewList = new ArrayList<>();
		this.backendCrewList = CrewInfoReader.getBackendCrewInfo();
		this.frontendCrewList = new ArrayList<>();
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

}
