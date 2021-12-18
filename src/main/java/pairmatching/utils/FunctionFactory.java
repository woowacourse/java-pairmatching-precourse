package pairmatching.utils;

import java.util.ArrayList;
import java.util.List;

public class FunctionFactory {

	private static final String PAIR_MATCHING = "1. 페어 매칭";
	private static final String PAIR_LOOKUP = "2. 페어 조회";
	private static final String RESET_PAIR = "3. 페어 초기화";
	private static final String QUIT = "Q. 종료";

	private FunctionFactory() {
	}

	public static List<String> makeFunctions() {
		List<String> functions = new ArrayList<>();
		functions.add(PAIR_MATCHING);
		functions.add(PAIR_LOOKUP);
		functions.add(RESET_PAIR);
		functions.add(QUIT);
		return functions;
	}
}
