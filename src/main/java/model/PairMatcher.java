package model;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import utils.CrewFileReader;

public class PairMatcher {
	private List<Crew> backEndCrews;
	private List<Crew> frontEndCrews;
	private List<String> shuffledBackEndCrews;
	private List<String> shuffledFrontEndCrews;

	public PairMatcher() {
		backEndCrews = CrewFileReader.readBackEndCrewFile()
			.stream()
			.map(crewName -> new Crew(crewName, "백엔드"))
			.collect(Collectors.toList());
		frontEndCrews = CrewFileReader.readFrontEndCrewFile()
			.stream()
			.map(crewName -> new Crew(crewName, "프론트엔드"))
			.collect(Collectors.toList());
	}

	public List<String> matchingPairs(List<String> processInformation) {
		if (processInformation.get(0).equals("백엔드")) {
			return matchingBackEndPairs(processInformation);
		} else if (processInformation.get(0).equals("프론트엔드")) {
			return matchingFrontEndPairs(processInformation);
		}
		throw new IllegalArgumentException();
	}

	private List<String> matchingBackEndPairs(List<String> processInformation) {
		shuffledBackEndCrews = Randoms.shuffle(
			backEndCrews.stream().map(crew -> crew.getName()).collect(Collectors.toList()));
		return shuffledBackEndCrews;
	}

	private List<String> matchingFrontEndPairs(List<String> processInformation) {
		shuffledFrontEndCrews = Randoms.shuffle(
			frontEndCrews.stream().map(crew -> crew.getName()).collect(Collectors.toList()));
		return shuffledFrontEndCrews;
	}
}
