package pairmatching.controller;

import java.util.List;
import java.util.function.Supplier;
import pairmatching.application.PairMatchingService;
import pairmatching.model.Pair;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.Parser;
import pairmatching.view.Validator;

public class PairMatchingController {
	private PairMatchingService pairMatchingService = new PairMatchingService();
	private Validator validator = new Validator();
	private Parser parser = new Parser();

	public void service() {
		while (true) {
			OutputView.printMain();
			String option = retryInput(() -> InputView.inputOption("1", "2", "3", "Q"));

			if (option.equals("Q")) {
				break;
			}

			handleMainPage(option);
		}
	}

	private void handleMainPage(String option) {
		if (option.equals("1")) {
			pairMatching();
		} else if (option.equals("2")) {
			printMatchedResult();
		} else if (option.equals("3")) {
			initializeMatchedPair();
		}
	}

	private void pairMatching() {
		OutputView.printMissionInformation();
		handlePairMatching();
	}

	private void handlePairMatching() {
		try {
			String information = inputInformationWithValidation();
			if (isWantToMatch(information)) {
				pairMatchingService.match(parser.parseToCourse(information), parser.parseToLevel(information),
					parser.parseToMission(information));
			}
			OutputView.printMatchingResult(
				pairMatchingService.findByCourseAndMission(parser.parseToCourse(information),
					parser.parseToMission(information)));
		} catch (IllegalArgumentException | IllegalStateException e) {
			OutputView.printErrorMessage(e.getMessage());
			handlePairMatching();
		}
	}

	private boolean isWantToMatch(String information) {
		boolean wantToMatch = true;

		if (pairMatchingService.hasMatched(parser.parseToCourse(information), parser.parseToMission(information))) {
			OutputView.printRematchingMessage();
			String value = retryInput(() -> InputView.inputOption("네", "아니오"));
			wantToMatch = parser.parseToIsWantToMatch(value);
		}

		return wantToMatch;
	}

	private void printMatchedResult() {
		OutputView.printMissionInformation();
		handlePrintMatchedResult();
	}

	private void handlePrintMatchedResult() {
		try {
			String information = inputInformationWithValidation();
			List<Pair> pairList =
				pairMatchingService.findByCourseAndMission(parser.parseToCourse(information),
					parser.parseToMission(information));
			OutputView.printMatchingResult(pairList);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
	}

	private void initializeMatchedPair() {
		pairMatchingService.initializeMatchedPair();
		OutputView.printInitializeMessage();
	}

	private String inputInformationWithValidation() {
		String information = retryInput(InputView::inputMatchingInformation);
		validator.validateCourseLevelMission(parser.parseToCourse(information), parser.parseToLevel(information),
			parser.parseToMission(information));
		return information;
	}

	private String retryInput(Supplier<String> supplier) {
		try {
			return supplier.get();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return retryInput(supplier);
		}
	}
}
