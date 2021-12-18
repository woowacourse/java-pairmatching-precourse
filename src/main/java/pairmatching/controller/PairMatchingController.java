package pairmatching.controller;

import static pairmatching.constants.Constants.*;
import static pairmatching.validation.PairMatchingValidation.*;
import static pairmatching.validation.UtilValidation.*;
import static pairmatching.view.ErrorView.*;
import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import pairmatching.model.PairMatching;

public class PairMatchingController {
	private final PairMatching pairMatching;

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
				requestLookingUp();
			}
			if (selectFunc == RESET_NUMBER) {
				requestReset();
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
		String input = selectCourse();
		try {
			String[] courseInput = isCourseInput(input);
			isExistCourse(courseInput);
			if (!pairMatching.matchingPair(courseInput)) {
				requestNewMatching();
				return;
			}
			pairMatching.printMatchingInfo(input);
		} catch (IllegalArgumentException illegalArgumentException) {
			printError(illegalArgumentException.getMessage());
			requestMatching();
		}
	}

	private void requestNewMatching() {
		String input = newMatching();
		if (input.equals(YES)) {
			System.out.println("Y");
		}
		if (input.equals(NO)) {
			System.out.println("N");
		}
	}

	private void requestLookingUp() {
		introCourse();
		String input = selectCourse();
		try {
			String[] courseInput = isCourseInput(input);
			isExistCourse(courseInput);
			pairMatching.printMatchingInfo(input);
		} catch (IllegalArgumentException illegalArgumentException) {
			printError(illegalArgumentException.getMessage());
			requestLookingUp();
		}
	}

	private void requestReset() {
		pairMatching.reset();
	}
}
