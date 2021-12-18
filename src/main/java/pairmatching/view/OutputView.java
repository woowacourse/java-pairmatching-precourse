package pairmatching.view;

import java.util.List;

import pairmatching.domain.Pair;
import pairmatching.util.Constants;

public class OutputView {
	public static void printProcess(String process) {
		System.out.println(process);
	}

	public static void printMatchingResult(List<Pair> pairs) {
		System.out.println(Constants.OUTPUT_MESSAGE_PAIR_MATCHING_RESULT);
		pairs.forEach(System.out::println);
	}

	public static void printInitialization() {
		System.out.println(Constants.OUTPUT_MESSAGE_INITIALIZATION);
	}
}
