package model;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import utils.CrewFileReader;

public class PairMatcher {
	private List<Crew> backEndCrewNames;
	private List<Crew> frontEndCrewNames;

	public PairMatcher() {
		backEndCrewNames = CrewFileReader.readBackEndCrewFile()
			.stream()
			.map(crewName -> new Crew(crewName, "백엔드"))
			.collect(Collectors.toList());
		frontEndCrewNames = CrewFileReader.readFrontEndCrewFile()
			.stream()
			.map(crewName -> new Crew(crewName, "프론트엔드"))
			.collect(Collectors.toList());
	}
}
