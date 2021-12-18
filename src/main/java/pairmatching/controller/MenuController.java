package pairmatching.controller;

import java.util.List;

import pairmatching.domain.Pair;
import pairmatching.domain.PairInfoDto;
import pairmatching.service.MemberService;
import pairmatching.service.MissionService;
import pairmatching.service.PairService;
import pairmatching.util.InformationValidator;
import pairmatching.util.PairGenerator;
import pairmatching.util.Parser;
import pairmatching.util.RetryValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MenuController {
	private static final String PAIR_MATCHING = "1";
	private static final String FIND_PAIR = "2";
	private static final String INITIALIZE_PAIR = "3";
	private static final String EXIT = "Q";
	private final PairService pairService = new PairService();

	public String runAndReturnCode(String menu, MissionService missionService, MemberService memberService) {
		if (menu.equals(PAIR_MATCHING)) {
			return runPairMatchingAndReturnCode(missionService, memberService);
		}
		if (menu.equals(FIND_PAIR)) {
			return findPairAndReturnCode(missionService);
		}
		if (menu.equals(INITIALIZE_PAIR)) {
			return initializePairAndReturnCode();
		}
		return EXIT;
	}

	private String initializePairAndReturnCode() {
		OutputView.printInitializeMessage();
		pairService.initializePairs();
		return INITIALIZE_PAIR;
	}

	private String findPairAndReturnCode(MissionService missionService) {
		OutputView.printStatus(missionService);
		PairInfoDto pairInfoDto = getPairInfoDto(missionService);
		List<Pair> pairs = pairService.findPairs(pairInfoDto);
		OutputView.printPairs(pairs);
		return FIND_PAIR;
	}

	private String runPairMatchingAndReturnCode(MissionService missionService, MemberService memberService) {
		OutputView.printStatus(missionService);
		PairInfoDto pairInfoDto = getPairInfoDto(missionService);
		PairGenerator.generate(memberService, pairInfoDto, pairService);
		List<Pair> pairs = pairService.findPairs(pairInfoDto);
		OutputView.printPairs(pairs);
		return PAIR_MATCHING;
	}

	private String getRetry() {
		try {
			String input = InputView.printDuplicateMatchMessage();
			RetryValidator.isRightRetry(input);
			return input;
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return getRetry();
		}
	}

	private PairInfoDto getPairInfoDto(MissionService missionService) {
		String input = inputInformation(missionService.getMissionNames());
		PairInfoDto pairInfoDto = Parser.splitInformation(input, missionService);
		return pairInfoDto;
	}

	private String inputInformation(List<String> missionNames) {
		try {
			String input = InputView.inputInformation();
			InformationValidator.isRightInformation(input, missionNames);
			return input;
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return inputInformation(missionNames);
		}
	}
}
