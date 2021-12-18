package pairmatching.service;

import static pairmatching.utils.Constants.*;
import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import pairmatching.domain.PairMatching;
import pairmatching.domain.repository.PairMatchingRepository;

public class PairMatchingService {
	public static void pairMatching(String course, String level, String mission) {
		PairMatchingRepository.add(course, level, mission);
		PairMatching pairMatching = PairMatchingRepository.find(course, level, mission);
		printPairMatchingResult(pairMatching.getPairMatchingResult());
	}

	public static void pairReMatching(String course, String level, String mission) {
		PairMatchingRepository.rematching(course, level, mission);
		PairMatching pairMatching = PairMatchingRepository.find(course, level, mission);
		printPairMatchingResult(pairMatching.getPairMatchingResult());
	}

}
