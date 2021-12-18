package pairmatching.controller;

import static pairmatching.constants.Constants.*;
import static pairmatching.validation.PairMatchingValidation.*;
import static pairmatching.validation.UtilValidation.*;
import static pairmatching.view.ErrorView.*;
import static pairmatching.view.InputView.*;

import pairmatching.model.MatchingHistory;
import pairmatching.model.MatchingInfo;

public class PairMatchingController {
	private MatchingHistory matchingHistory;
	private MatchingInfo matchingInfo;

	public PairMatchingController(MatchingHistory matchingHistory, MatchingInfo matchingInfo) {
		this.matchingHistory = matchingHistory;
		this.matchingInfo = matchingInfo;
	}

	public void run() {
		while (true) {
			int selectFunc = requestSelectFunction();
			System.out.println("selectFunc = " + selectFunc);
		}
	}

	private int requestSelectFunction() {
		String selectNumber = selectFunction();
		if (selectNumber.equals(QUIT_CHAR)) {
			return QUIT_NUMBER;
		}
		try {
			isNumber(selectNumber);
			isFunctionNumber(selectNumber);
		} catch (IllegalArgumentException illegalArgumentException) {
			printError(illegalArgumentException.getMessage());
			return requestSelectFunction();
		}
		return Integer.parseInt(selectNumber);
	}
}
