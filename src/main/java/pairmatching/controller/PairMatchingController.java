package pairmatching.controller;

import static pairmatching.constant.constant.*;
import static pairmatching.exception.EmptyException.*;
import static pairmatching.exception.FunctionException.*;
import static pairmatching.exception.SourceFormatException.*;

import java.io.IOException;

import pairmatching.exception.NotFindMatchException;
import pairmatching.model.Function;
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
		} while (!Function.isExit(function));
	}

	private void proceedFunction(String function) throws IOException {
		if (Function.isMatch(function)) {
			matchPair(checkEmptyInput(inputView.requestSource()));
		}
		if (Function.isLook(function)) {
			lookPair(checkEmptyInput(inputView.requestSource()));
		}
		if (Function.isInit(function)) {
			pairService.init();
			outputView.reportInit();
		}
	}

	private void lookPair(String source) {
		checkSourceFormat(source);
		String[] sourceSplitByComma = source.replaceAll(BLANK, "").split(COMMA);
		if (!pairService.findMatch(sourceSplitByComma[COURSE_IDX], sourceSplitByComma[LEVEL_IDX], sourceSplitByComma[MISSION_IDX])) {
			throw new NotFindMatchException();
		}
		Match match = pairService.look(sourceSplitByComma[COURSE_IDX], sourceSplitByComma[LEVEL_IDX], sourceSplitByComma[MISSION_IDX]);
		outputView.reportMatch(match.getPair());
	}

	private void matchPair(String source) throws IOException {
		checkSourceFormat(source);
		String[] sourceSplitByComma = source.replaceAll(BLANK, "").split(COMMA);
		if (pairService.findMatch(sourceSplitByComma[COURSE_IDX], sourceSplitByComma[LEVEL_IDX], sourceSplitByComma[MISSION_IDX])) {
			String match = inputView.requestDuplicateMatch();
			if (match.equals(NOT_MATCHING_MSG)) {
				run();
			}
		}
		Match match = pairService.match(sourceSplitByComma[COURSE_IDX], sourceSplitByComma[LEVEL_IDX], sourceSplitByComma[MISSION_IDX]);
		outputView.reportMatch(match.getPair());
	}
}
