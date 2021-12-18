package pairmatching.view;

import java.util.List;

import pairmatching.utils.PairMatchingMessage;

public class PairMachiningOutput {

	public void printMatchingResult(List<String> names) {
		System.out.println(PairMatchingMessage.MATCHING_RESULT);
		names.forEach(System.out::println);
	}

	public void printClearPairResult() {
		System.out.println(PairMatchingMessage.ALL_CLEAR);
	}
}
