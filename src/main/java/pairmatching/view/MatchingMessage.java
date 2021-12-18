package pairmatching.view;

import java.util.List;
import java.util.Map;

public class MatchingMessage {

	public static final String REMATCH_OR_NOT = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
	public static final String INPUT_EXAMPLE = "네 | 아니오";
	public static final String MATCHING_MANUAL = "\n페어 매칭 결과입니다.";

	public static void printManual() {
		System.out.println(REMATCH_OR_NOT);
		System.out.println(INPUT_EXAMPLE);
	}

	public static void printPairList(List<String> pairList) {
		System.out.println(MATCHING_MANUAL);
		pairList.stream()
			.forEachOrdered(str ->
				System.out.println(str)
			);
	}
}
