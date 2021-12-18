package pairmatching.controller;

import static pairmatching.exception.EmptyException.*;
import static pairmatching.exception.FunctionException.*;
import static pairmatching.exception.SourceFormatException.*;

import java.io.IOException;

import pairmatching.exception.NotFindMatchException;
import pairmatching.model.Match;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	String function;
	InputView inputView;
	OutputView outputView;
	PairService pairService;

	public PairMatchingController() {
		function = "";
		inputView = new InputView();
		outputView = new OutputView();
		pairService = new PairService();
	}

	public void run() {
		do {
			String input = inputView.requestFunction();
			try {
				function = checkCorrectFunction(checkEmptyInput(input));
				proceedFunction(function);
			} catch (Exception exception) {
				outputView.reportException(exception.getMessage());
			}
		} while (!function.equals("Q"));
	}

	private void proceedFunction(String function) throws IOException {
		if (function.equals("1")) {
			matchPair(checkEmptyInput(inputView.requestSource()));
		}
		if (function.equals("2")) {
			lookPair(checkEmptyInput(inputView.requestSource()));
		}
		if (function.equals("3")) {
			pairService.init();
			outputView.reportInit();
		}
	}

	private void lookPair(String source) {
		checkSourceFormat(source);
		String[] sourceSplitByComma = source.replaceAll(" ", "").split(",");
		if (!pairService.findMatch(sourceSplitByComma[0], sourceSplitByComma[1], sourceSplitByComma[2])) {
			throw new NotFindMatchException();
		}
		Match match = pairService.look(sourceSplitByComma[0], sourceSplitByComma[1], sourceSplitByComma[2]);
		outputView.reportMatch(match.getPair());
	}

	private void matchPair(String source) throws IOException {
		checkSourceFormat(source);
		String[] sourceSplitByComma = source.replaceAll(" ", "").split(",");
		if (pairService.findMatch(sourceSplitByComma[0], sourceSplitByComma[1], sourceSplitByComma[2])) {
			String match = inputView.requestDuplicateMatch();
			if (match.equals("아니오")) {
				run();
			}
		}
		Match match = pairService.match(sourceSplitByComma[0], sourceSplitByComma[1], sourceSplitByComma[2]);
		outputView.reportMatch(match.getPair());
	}
}
