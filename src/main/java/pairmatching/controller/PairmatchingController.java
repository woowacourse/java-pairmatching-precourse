package pairmatching.controller;

import static pairmatching.constant.message.SystemMessage.*;

import java.util.LinkedHashMap;
import java.util.Map;

import pairmatching.domain.PairMatch;
import pairmatching.dto.ChoiceDto;
import pairmatching.service.PairmatchingService;
import pairmatching.util.Voider;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingController {

	public static final String INPUT_NO = "아니오";
	private Map<String, Voider> mainChoiceMap = new LinkedHashMap<>();
	private static PairmatchingService pairmatchingService = new PairmatchingService();

	{
		mainChoiceMap.put("1", PairmatchingController::toMatching);
		mainChoiceMap.put("2", PairmatchingController::toRetrieve);
		mainChoiceMap.put("3", PairmatchingController::toClear);
		mainChoiceMap.put("Q", PairmatchingController::toExit);
	}

	public void run() {
		String input = "";
		do {
			input = InputView.chooseEntryMenu();
			mainChoiceMap.get(input).execute();
		} while (!input.equals(QUIT));
	}

	private static void toMatching() {
		String input = InputView.inputMatching();
		ChoiceDto choiceDto = new ChoiceDto(input);
		PairMatch findPairMatch = pairmatchingService.retrievePairs(choiceDto);
		if (findPairMatch != null) {
			String inputMatchingAgain = InputView.getMatchingAgain();
			if (inputMatchingAgain.equals(INPUT_NO)) {
				return;
			}
		}
		PairMatch lastPairMatch = pairmatchingService.makePairs(choiceDto);
		OutputView.outputPairMatchingResult(lastPairMatch);
	}

	private static void toRetrieve() {
		String input = InputView.inputRetrieve();
		ChoiceDto choiceDto = new ChoiceDto(input);
		PairMatch findPairMatch = pairmatchingService.retrievePairs(choiceDto);
		OutputView.outputPairMatchingResult(findPairMatch);
	}

	private static void toClear() {
		pairmatchingService.clearAllPairs();
		OutputView.printClearMessage();
	}

	/**
	 * 종료: 아무것도 하지 않습니다
	 */
	private static void toExit() {

	}
}
