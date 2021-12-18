package pairmatching.utils;

import java.util.regex.Pattern;

public class PairMatchingSelectOptionPattern {
	private static Pattern pattern = null;
	private static final String PAIR_MATCHING_SELECTION_REG = "([\\S]+), ([\\S]+), ([\\S]+)";

	private PairMatchingSelectOptionPattern() {

	}

	public static Pattern getPattern() {
		if (pattern == null) {
			pattern = Pattern.compile(PAIR_MATCHING_SELECTION_REG);
		}
		return pattern;
	}
}
