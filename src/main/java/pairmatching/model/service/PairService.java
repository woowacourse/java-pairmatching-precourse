package pairmatching.model.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.CrewList;
import pairmatching.model.PairMatching;
import pairmatching.model.repository.PairMatchingRepository;

public class PairService {

	CrewList crewList = new CrewList();

	ArrayList<String> backCrewList = crewList.getBackendCrewList();
	ArrayList<String> frontCrewList = crewList.getFrontendCrewList();

	public void makePairMatching(String pairMatchingInput) {
		String[] split = pairMatchingInput.split(",");

		ifLengthThree(split);

		ifLengthTwo(split);
	}

	private void ifLengthTwo(String[] split) {
		if (split.length == 2) {
			PairMatching pairMatching = new PairMatching(split[0].trim(), split[1].trim());

			if (pairMatching.getCourse().equals("백엔드")) {
				pairMatching.setPairList(makePairList(backCrewList));
			}
			if (pairMatching.getCourse().equals("프론트엔드")) {
				pairMatching.setPairList(makePairList(frontCrewList));
			}

			PairMatchingRepository.pairMatchingRepository.add(pairMatching);
		}
	}

	private void ifLengthThree(String[] split) {
		if (split.length == 3) {
			PairMatching pairMatching = new PairMatching(split[0].trim(), split[1].trim(), split[2].trim());

			if (pairMatching.getCourse().equals("백엔드")) {
				pairMatching.setPairList(makePairList(backCrewList));
			}
			if (pairMatching.getCourse().equals("프론트엔드")) {
				pairMatching.setPairList(makePairList(frontCrewList));
			}

			PairMatchingRepository.pairMatchingRepository.add(pairMatching);
		}
	}

	private ArrayList<String> makePairList(ArrayList<String> crewList) {
		List<String> shuffleList = Randoms.shuffle(crewList);
		return (ArrayList<String>)shuffleList;
	}
}
