package pairmatching.utils;

public class Validator {
	public static void checkName(String name) throws IllegalArgumentException {
		if (!name.matches(MyRegex.ONLY_KOREAN_AND_ENGLISH.getRegexPattern())) {
			throw new IllegalArgumentException();
		}
	}
}
