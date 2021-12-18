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
		if (processInformation.get(0).equals("백엔드") && !isAlreadyMatchedForBackEndLevel(processInformation)) {
			return matchingBackEndPairs(processInformation);
		} else if (processInformation.get(0).equals("프론트엔드") && !isAlreadyMatchedForFrontEndLevel(processInformation)) {
			return matchingFrontEndPairs(processInformation);
		}
		throw new IllegalArgumentException();
	}

	private boolean isAlreadyMatchedForBackEndLevel(List<String> processInformation) {
		if (backEndCrews.stream().anyMatch(crew -> crew.isAlreadyMatched(processInformation.get(1)))) {
			throw new IllegalArgumentException("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
		}
		return false;
	}

	private boolean isAlreadyMatchedForFrontEndLevel(List<String> processInformation) {
		if (frontEndCrews.stream().anyMatch(crew -> crew.isAlreadyMatched(processInformation.get(1)))) {
			throw new IllegalArgumentException("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
		}
		return false;
	}

	private List<String> matchingBackEndPairs(List<String> processInformation) {
		backEndCrews.stream().forEach(crew -> crew.addMatchedLevel(processInformation.get(1)));
		shuffledBackEndCrews = Randoms.shuffle(
			backEndCrews.stream().map(crew -> crew.getName()).collect(Collectors.toList()));
		return shuffledBackEndCrews;
	}

	private List<String> matchingFrontEndPairs(List<String> processInformation) {
		frontEndCrews.stream().forEach(crew -> crew.addMatchedLevel(processInformation.get(1)));
		shuffledFrontEndCrews = Randoms.shuffle(
			frontEndCrews.stream().map(crew -> crew.getName()).collect(Collectors.toList()));
		return shuffledFrontEndCrews;
	}
}
