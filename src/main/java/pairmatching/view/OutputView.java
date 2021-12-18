package pairmatching.view;

import java.util.List;

public class OutputView {
	private static final String MATCHING_RESULT_MESSAGE = "페어 매칭 결과입니다.";
	private final static String COLON = " : ";
	private final static String END_LINE = "\n";

	public void printMatchingResult(List<List<String>> matchingResult) {
		StringBuilder message = new StringBuilder();
		message.append(END_LINE).append(MATCHING_RESULT_MESSAGE).append(END_LINE);
		for (List<String> result : matchingResult) {
			message.append(String.join(COLON, result));
			message.append(END_LINE);
		}
		System.out.println(message);
	}
}
