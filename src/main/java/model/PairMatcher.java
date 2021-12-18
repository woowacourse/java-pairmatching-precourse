package model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import utils.CrewFileReader;

public class PairMatcher {
	private List<String> backEndCrewNames;
	private List<String> frontEndCrewNames;
	private List<String> shuffledBackEndCrew;
	private List<String> shuffledFrontEndCrew;

	public PairMatcher() {
		backEndCrewNames = CrewFileReader.readBackEndCrewFile();
		frontEndCrewNames = CrewFileReader.readFrontEndCrewFile();
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
		shuffledBackEndCrew = Randoms.shuffle(backEndCrewNames);
		return shuffledBackEndCrew;
	}

	private List<String> matchingFrontEndPairs(List<String> processInformation) {
		shuffledFrontEndCrew = Randoms.shuffle(frontEndCrewNames);
		return shuffledFrontEndCrew;
	}
}
