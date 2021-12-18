package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.ResponseValidator;
import pairmatching.utils.FunctionValidator;
import pairmatching.utils.MissionValidator;

public class InputView {

	public static final String REQUEST_TRY = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
	public static final String YES_OR_NO = "네 | 아니오";
	public static final String YES = "네";
	public static final String NO = "아니오";

	public static String requestFunction() {
		try {
			OutputView.printMainScreen();
			String inputValue = Console.readLine();
			FunctionValidator.validateFunction(inputValue);
			return inputValue;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return requestFunction();
		}
	}

	public static String requestMission() {
		try {
			OutputView.printPairScreen();
			String inputValue = Console.readLine();
			MissionValidator.validateMission(inputValue);
			return inputValue;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return requestMission();
		}
	}

	public static boolean requestTry() {
		try {
			System.out.println(REQUEST_TRY);
			System.out.println(YES_OR_NO);
			String response = Console.readLine();
			ResponseValidator.validateResponse(response);
			if (response.equals(YES)) {
				return true;
			}
			if (response.equals(NO)) {
				return false;
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return requestTry();
		}
		return false;
	}
}
