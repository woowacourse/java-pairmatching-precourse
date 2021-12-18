package pairmatching.controller;

import java.util.List;
import java.util.function.Supplier;
import pairmatching.application.PairMatchingService;
import pairmatching.model.Pair;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.Validator;

public class PairMatchingController {
	private PairMatchingService pairMatchingService = new PairMatchingService();
	private Validator validator = new Validator();

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
				pairMatchingService.match(parseToCourse(information), parseToLevel(information),
					parseToMission(information));
			}
			OutputView.printMatchingResult(
				pairMatchingService.findByCourseAndMission(parseToCourse(information), parseToMission(information)));
		} catch (IllegalArgumentException | IllegalStateException e) {
			OutputView.printErrorMessage(e.getMessage());
			handlePairMatching();
		}
	}

	private boolean isWantToMatch(String information) {
		boolean wantToMatch = true;

		if (pairMatchingService.hasMatched(parseToCourse(information), parseToMission(information))) {
			OutputView.printRematchingMessage();
			String value = retryInput(() -> InputView.inputOption("네", "아니오"));
			wantToMatch = parseToIsWantToMatch(value);
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
				pairMatchingService.findByCourseAndMission(parseToCourse(information), parseToMission(information));
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
		validator.validateCourseLevelMission(parseToCourse(information), parseToLevel(information),
			parseToMission(information));
		return information;
	}

	private boolean parseToIsWantToMatch(String value) {
		if (value.equals("아니오")) {
			return false;
		}
		return true;
	}

	private String parseToCourse(String information) {
		return information.split(",")[0].trim();
	}

	private String parseToLevel(String information) {
		return information.split(",")[1].trim();
	}

	private String parseToMission(String information) {
		return information.split(",")[2].trim();
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
