package pairmatching.utils;

import java.util.Arrays;
import java.util.List;

import pairmatching.constant.PairMatchingConst;

public class Validator {
	public static void validateSelection(String userSelection) {
		List<String> validSelections = Arrays.asList(
			PairMatchingConst.SELECT_PAIR_MATCHING,
			PairMatchingConst.SELECT_PAIR_READ,
			PairMatchingConst.SELECT_PAIR_RESET,
			PairMatchingConst.SELECT_EXIT);

		if (!validSelections.contains(userSelection)) {
			throw new IllegalArgumentException("[ERROR] 지정된 입력만 입력가능합니다.");
		}
	}
}
