package pairmatching.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

		for (PairMatching pairMatching : PairMatchingRepository.repo) {
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

			///

			PairMatchingRepository.repo.add(pairMatching);
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

			///

			PairMatchingRepository.repo.add(pairMatching);
		}
	}

	private ArrayList<String> makePairList(ArrayList<String> crewList) {
		List<String> shuffleList = Randoms.shuffle(crewList);
		return (ArrayList<String>)shuffleList;
	}

	public PairMatching findPairMatching(String pairMatchingInput) {
		String[] split = pairMatchingInput.split(",");

		for (PairMatching pairMatching : PairMatchingRepository.repo) {
			if (split.length == 3) {
				if (pairMatching.getCourse().equals(split[0].trim()) && pairMatching.getLevel().equals(split[1].trim())
					&& pairMatching.getMission().equals(split[2].trim())) {
					return pairMatching;
				}
			}

			if (split.length == 2) {
				if (pairMatching.getCourse().equals(split[0].trim()) && pairMatching.getLevel()
					.equals(split[1].trim())) {
					return pairMatching;
				}
			}
		}

		return new PairMatching("error", "error", "error");
	}

	public boolean isSamePairInSameLevel(PairMatching pairMatching) {
		String course = pairMatching.getCourse();
		String level = pairMatching.getLevel();
		List<ArrayList<String>> sameLevelPairListList = PairMatchingRepository.repo.stream()
			.filter(repo -> repo.getLevel().equals(level)).filter(repo -> repo.getCourse().equals(course))
			.map(repo -> repo.getPairList())
			.collect(Collectors.toList());

		ArrayList<String> pairList = pairMatching.getPairList();

		if (pairList.size() % 2 == 0) {
			for (ArrayList<String> sameLevelPairList : sameLevelPairListList) {
				for (int i = 0; i < pairList.size(); i += 2) {
					String name = pairList.get(i);
					String pairName = pairList.get(i + 1);

					for (int j = 0; j < sameLevelPairList.size(); j++) {
						if (sameLevelPairList.get(i).equals(name)) {
							if (i % 2 == 0 && sameLevelPairList.get(i + 1).equals(pairName)) {
								return true;
							}

							if (i % 2 != 0 && sameLevelPairList.get(i - 1).equals(pairName)) {
								return true;
							}
						}
					}
				}
			}
		}

		// if (pairList.size() % 2 != 0) {
		// 	for (ArrayList<String> sameLevelPairList : sameLevelPairListList) {
		// 		for (int i = 0; i < pairList.size(); i += 2) {
		// 			String name = pairList.get(i);
		// 			String pairName = pairList.get(i + 1);
		//
		// 			for (int j = 0; j < sameLevelPairList.size(); j++) {
		// 				if (sameLevelPairList.get(i).equals(name)) {
		// 					if (i % 2 == 0 && sameLevelPairList.get(i + 1).equals(pairName)) {
		// 						return true;
		// 					}
		//
		// 					if (i % 2 != 0 && sameLevelPairList.get(i - 1).equals(pairName)) {
		// 						return true;
		// 					}
		// 				}
		// 			}
		// 		}
		// 	}
		// }

		return false;
	}
}
