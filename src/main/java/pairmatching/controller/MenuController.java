package pairmatching.controller;

import java.util.List;

import pairmatching.domain.PairInfoDto;
import pairmatching.service.MemberService;
import pairmatching.service.MissionService;
import pairmatching.service.PairService;
import pairmatching.util.InformationValidator;
import pairmatching.util.PairGenerator;
import pairmatching.util.Parser;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MenuController {
	private static final String PAIR_MATCHING = "1";
	private static final String FIND_PAIR = "2";
	private static final String INITIALIZE_PAIR = "3";
	private static final String EXIT = "Q";
	private final PairService pairService = new PairService();

	public void run(String menu, MissionService missionService, MemberService memberService) {
		if (menu.equals(PAIR_MATCHING)) {
			OutputView.printStatus(missionService);
			String input = inputInformation(missionService.getMissionNames());
			PairInfoDto pairInfoDto = Parser.splitInformation(input, missionService);
			PairGenerator.generate(memberService, pairInfoDto, pairService);
			OutputView.printPairs(pairService.findPairs(pairInfoDto));
			return;
		}
		if (menu.equals(FIND_PAIR)) {
			OutputView.printStatus(missionService);
			return;
		}
		if (menu.equals(INITIALIZE_PAIR)) {
			OutputView.printInitializeMessage();
		}
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
