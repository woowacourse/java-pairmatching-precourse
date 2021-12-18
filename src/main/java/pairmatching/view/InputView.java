package pairmatching.view;

import static pairmatching.utils.validator.InputValidator.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String inputPairFunction() {
		return Console.readLine();
	}

	public static String inputPairMatching() {
		System.out.println("과정, 레벨, 미션을 선택하세요.");
		System.out.println("ex) 백엔드, 레벨1, 자동차경주");
		return Console.readLine();
	}

	public static String inputRequestRematching() {
		System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
		System.out.println("네 | 아니오");
		String input = Console.readLine();
		try {
			validateInputRequestRematching(input);
			return input;
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			return inputRequestRematching();
		}
	}
}
