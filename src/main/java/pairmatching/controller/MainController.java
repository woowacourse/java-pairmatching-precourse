package pairmatching.controller;

import static pairmatching.utils.Constant.*;
import static pairmatching.view.ErrorMessage.*;

import pairmatching.domain.MatchingInfo;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MatchingRepository;
import pairmatching.service.PairMatchingService;
import pairmatching.service.UserService;
import pairmatching.view.OutputView;

import java.util.List;

public class MainController {
	private final InitController initController = new InitController();
	private final UserService userService = new UserService();
	private final MatchingRepository matchingRepository = MatchingRepository.getInstance();
	private final PairMatchingService pairMatchingService = new PairMatchingService();
	private final CrewRepository crewRepository = CrewRepository.getInstance();
	private final PairMatchingController pairMatchingController = new PairMatchingController();

	public String run() {
		initController.initSettings();
		String userMode = getModeFromUser();

		OutputView.pairMatchingView();

		if (userMode.equals(SELECT_PAIR_MATCHING)) {
			runPairMatching();
		} else if (userMode.equals(SELECT_PAIR_SEARCH)) {
			runPairFind();
		} else if (userMode.equals(SELECT_PAIR_RESET)) {
			resetPair();
		} else if (userMode.equals(SELECT_PAIR_QUIT)) {
			return EXIT;
		}

		return AGAIN;
	}

	private void resetPair() {
		matchingRepository.resetMatchingInfo();
		OutputView.showResetSuccess();
	}

	private void runPairFind() {
		List<String> findMatchingInfo = getPairMatchingInfoFromUser();
		if (pairMatchingService.isMatched(findMatchingInfo)) {
			MatchingInfo findMatch = matchingRepository.findByInfo(findMatchingInfo);
			OutputView.showMatchingCrews(findMatch.getShuffledCrew());
			return;
		}
		OutputView.errorMessage(ERROR_NO_SUCH_INFO);
	}

	private void runPairMatching() {
		List<String> pairMatchingInfo = getPairMatchingInfoFromUser();
		pairMatchingController.run(pairMatchingInfo);
	}

	private List<String> getPairMatchingInfoFromUser() {
		List<String> selectInfos = NOT_EXISTED;
		while (selectInfos.isEmpty()) {
			selectInfos = userService.getUserPairMatchingCourseLevelMission();
		}

		return selectInfos;
	}

	private String getModeFromUser() {
		String userMode = START;

		while (userMode.equals(AGAIN)) {
			userMode = userService.getUserMode();
		}

		return userMode;
	}
}
