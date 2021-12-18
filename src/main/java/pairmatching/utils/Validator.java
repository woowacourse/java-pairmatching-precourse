package pairmatching.utils;

import java.util.HashSet;
import java.lang.IllegalArgumentException;

public class Validator {
	public static void checkName(String name) throws IllegalArgumentException {
		if (!name.matches(MyRegex.ONLY_KOREAN_AND_ENGLISH.getRegexPattern())) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_PATTERN_MSG.getMessage());
		}
	}

	public static void checkDuplicate(String name, HashSet<String> uniqueNameSet) throws IllegalArgumentException {
		if (uniqueNameSet.contains(name)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_MSG.getMessage());
		}
		uniqueNameSet.add(name);
	}
}
