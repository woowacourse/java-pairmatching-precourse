package pairmatching.controller;

import static pairmatching.constants.Constants.*;
import static pairmatching.validation.PairMatchingValidation.*;
import static pairmatching.validation.UtilValidation.*;
import static pairmatching.view.ErrorView.*;
import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import pairmatching.model.PairMatching;

public class PairMatchingController {
	private PairMatching pairMatching;

	public PairMatchingController(PairMatching pairMatching) {
		this.pairMatching = pairMatching;
	}

	public void run() {
		while (true) {
			int selectFunc = requestSelectFunction();
			if (selectFunc == MATCHING_NUMBER) {
				requestMatching();
			}
			if (selectFunc == LOOK_UP_NUMBER) {
				System.out.println("조회");
			}
			if (selectFunc == RESET_NUMBER) {
				System.out.println("초기화");
			}
			if (selectFunc == QUIT_NUMBER) {
				break;
			}
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

	private void requestMatching() {
		introCourse();
		try {
			String[] courseInput = isCourseInput(selectCourse());
			isExistCourse(courseInput);
			pairMatching.matchingPair(courseInput);
		} catch (IllegalArgumentException illegalArgumentException) {
			printError(illegalArgumentException.getMessage());
			requestMatching();
		}
	}
}
