package pairmatching;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Console;

public class PairMatchingController {
	private static final String FUNCTION_SELECT_TEXT = "기능을 선택하세요.";

	HashMap<String, String> functions = new HashMap<>();

	public PairMatchingController() {
		functions.put("1", "페어 매칭");
		functions.put("2", "페어 조회");
		functions.put("3", "페어 초기화");
		functions.put("Q", "종료");
	}

	public void run() {
		requestFunctionSelect();
	}

	private void requestFunctionSelect() {
		printFunctions();
		Console.readLine();
	}

	private void printFunctions() {
		System.out.println(FUNCTION_SELECT_TEXT);
		functions.keySet().stream().sorted()
			.forEach(k -> System.out.println(k + ". " + functions.get(k)));
	}
}
