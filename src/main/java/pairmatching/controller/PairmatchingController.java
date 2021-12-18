package pairmatching.controller;

import static pairmatching.constant.message.SystemMessage.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.dto.ChoiceDto;
import pairmatching.validator.InputValidator;
import pairmatching.view.InputView;

public class PairmatchingController {

	public Map<String, Supplier<String>> mainChoiceMap = new LinkedHashMap<>();

	{
		mainChoiceMap.put("1", PairmatchingController::toMatching);
		mainChoiceMap.put("2", PairmatchingController::toRetrieve);
		mainChoiceMap.put("3", PairmatchingController::toClear);
	}

	public void run() {
		String input = "";
		do {
			input = InputView.chooseEntryMenu();
			mainChoiceMap.get(input).get();
		} while (!input.equals(QUIT));
	}

	private static String toMatching() {
		String input = InputView.inputMatching();
		ChoiceDto choiceDto = new ChoiceDto(input);
		return "";
	}

	private static String toRetrieve() {
		String input = InputView.inputRetrieve();
		ChoiceDto choiceDto = new ChoiceDto(input);
		return "";
	}

	private static String toClear() {
		System.out.println("초기화 되었습니다. ");
		return CHOICE_CLEAR;
	}
}
