package pairmatching.utils;

import static pairmatching.utils.Constant.*;

import java.util.Arrays;
import java.util.List;

public class Parser {
	public static List<String> parsePairMatchingInfo(String parsingLine) {
		Validator.validateInputFormat(parsingLine);
		String[] infos = parsingLine.split(SPLIT);

		return Arrays.asList(infos);
	}
}
