package pairmatching.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import pairmatching.domain.ContinuePairMatching;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingFunction;
import pairmatching.domain.Mission;
import pairmatching.domain.PairMatching;
import pairmatching.domain.PairMatchings;
import pairmatching.util.Constant;
import pairmatching.util.CrewParse;
import pairmatching.util.FileInput;
import pairmatching.util.Validation;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	public void start() {
		Crews crews = inputCrews();
		PairMatchings pairMatchings = new PairMatchings();

		while (true) {
			MatchingFunction matchingFunction = inputFunction();
			if (matchingFunction == MatchingFunction.QUIT) {
				break;
			}
			if (matchingFunction == MatchingFunction.INITIALIZATION) {
				functionInitialization(pairMatchings);
				continue;
			}
			OutputView.printCourseAndMission();
			if (matchingFunction == MatchingFunction.MATCHING) {
				pairMatchings.addPairMatching(functionMatching(pairMatchings, crews));
			}
			if (matchingFunction == MatchingFunction.LOOKUP) {
				functionLookUp(pairMatchings);
			}
		}
	}

	public Crews inputCrews() {
		List<Crew> crewList = new ArrayList<>();
		crewList.addAll(CrewParse.make(Course.BACKEND, FileInput.input(Constant.backendCrewFileName)));
		crewList.addAll(CrewParse.make(Course.FRONTEND, FileInput.input(Constant.frontendCrewFileName)));
		return new Crews(crewList);
	}

	public MatchingFunction inputFunction() {
		try {
			return MatchingFunction.fromString(InputView.getFunction());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return inputFunction();
		}
	}

	public void functionInitialization(PairMatchings pairMatchings) {
		pairMatchings.initialization();
	}

	public PairMatching functionMatching(PairMatchings pairMatchings, Crews crews) {
		PairMatching pairMatching;
		Optional<PairMatching> findPairMatching;
		do {
			pairMatching = getMatchingInfo();
			findPairMatching = pairMatchings.find(pairMatching);
		} while (!possiblePairMatching(findPairMatching));

		pairMatching.makeMatching(crews);
		OutputView.printPairResult(pairMatching);
		return pairMatching;
	}

	public void functionLookUp(PairMatchings pairMatchings) {
		PairMatching pairMatching = getMatchingInfo();
		Optional<PairMatching> findPairMatching = pairMatchings.find(pairMatching);

		if (containsPairMatching(findPairMatching)) {
			OutputView.printPairResult(findPairMatching.get());
		}
	}

	public PairMatching getMatchingInfo() {
		try {
			String matchingInfo = InputView.getPairMathing();
			Validation.matchingInfoLength(matchingInfo);
			List<String> pairMatching = Arrays.stream(matchingInfo.split(Constant.SPLIT))
				.collect(Collectors.toList());
			return new PairMatching(Course.fromString(pairMatching.get(Constant.COURSE_INDEX)),
				Level.fromString(pairMatching.get(Constant.LEVEL_INDEX)),
				Mission.fromString(pairMatching.get(Constant.MISSION_INDEX)));
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getMatchingInfo();
		}
	}

	public boolean possiblePairMatching(Optional<PairMatching> pairMatching) {
		if (pairMatching.isPresent()) {
			ContinuePairMatching continuePairMatching = getContinuePairMatching();
			return continuePairMatching == ContinuePairMatching.YES;
		}
		return true;
	}

	public ContinuePairMatching getContinuePairMatching() {
		try {
			String continuePairMatching = InputView.getContinuePairMatching();
			return ContinuePairMatching.fromString(continuePairMatching);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getContinuePairMatching();
		}
	}

	public boolean containsPairMatching(Optional<PairMatching> pairMatching) {
		if (!pairMatching.isPresent()) {
			OutputView.printPairResultNone();
			return false;
		}
		return true;
	}
}
