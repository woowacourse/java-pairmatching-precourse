package pairmatching.Util;

import java.util.Arrays;
import java.util.List;

public class ParsingString {

	public static List<String> splitComma(String input) {
		return Arrays.asList(input.split(",").clone());
	}
}
