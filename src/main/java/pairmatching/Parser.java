package pairmatching;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

	public static List<String> matchingStatus(String input) {
		return removeBlank(splitByComma(input));
	}

	private static String[] splitByComma(String input) {
		return input.split(",");
	}

	public static List<String> removeBlank(String[] input) {
		return Stream.of(input).map(String::trim).collect(Collectors.toList());
	}
}
