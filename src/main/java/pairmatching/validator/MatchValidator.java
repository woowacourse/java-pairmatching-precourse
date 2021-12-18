package pairmatching.validator;

import static pairmatching.view.ViewConstants.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchValidator implements Validator {
	private static Pattern pattern = Pattern.compile("^[가-힣a-zA-Z0-9]+,\\s[가-힣a-zA-Z0-9]+,\\s[가-힣a-zA-Z0-9]+");

	@Override
	public void exceptionInvalid(String string) {
		Matcher matcher = pattern.matcher(string);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
		}
	}
}
