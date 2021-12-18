package pairmatching.controller;

import pairmatching.exception.DuplicatedCrewNameException;
import pairmatching.model.CrewNameReader;
import pairmatching.model.CrewRepository;

public class CrewMatchingController {
	private CrewRepository frontendCrews;
	private CrewRepository backendCrews;

	public void start() {
		setupCrewInfo();
		System.out.println();
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
