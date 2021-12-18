package pairmatching;

import java.util.List;

public class ResultView {
	private static final String MESSAGE_MATCHING_RESULT = "페어 매칭 결과입니다.";
	private static final String MESSAGE_MATCH_INITIATED = "초기화 되었습니다.";

	public static void printMatchingResult(List<Pair> pairList) {
		System.out.println(MESSAGE_MATCHING_RESULT);
		for (Pair pair : pairList) {
			System.out.println(pair.toString());
		}
	}

	public static void printMatchInitiated() {
		System.out.println(MESSAGE_MATCH_INITIATED);
	}
}
