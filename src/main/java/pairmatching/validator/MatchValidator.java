package pairmatching.validator;

import static pairmatching.Constants.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchValidator implements Validator {
	private static Pattern pattern = Pattern.compile(PATTERN);

	@Override
	public void exceptionInvalid(String string) {
		Matcher matcher = pattern.matcher(string);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
		}
	}
}
