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

	public boolean isAlreadyPairMatching(String pairMatchingInput) {
		String[] split = pairMatchingInput.split(",");

		for (PairMatching pairMatching : PairMatchingRepository.pairMatchingRepository) {
			if (isEqualPairMatching(pairMatching, split)) {
				return true;
			}
		}

		return false;
	}

	private boolean isEqualPairMatching(PairMatching pairMatching, String[] split) {
		if (split.length == 3) {
			if (pairMatching.getCourse().equals(split[0].trim()) && pairMatching.getLevel().equals(split[1].trim())
				&& pairMatching.getMission().equals(split[2].trim())) {
				return true;
			}
		}

		if (split.length == 2) {
			if (pairMatching.getCourse().equals(split[0].trim()) && pairMatching.getLevel().equals(split[1].trim())) {
				return true;
			}
		}

		return false;
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
