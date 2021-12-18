package pairmatching.service;

import javafx.util.Pair;
import pairmatching.validator.PairMatchingValidator;

public class PairMatchingService {
	PairMatchingValidator pairMatchingValidator = new PairMatchingValidator();

	public void start(String rawInfo) {
		pairMatchingValidator.isValidInput(rawInfo);
		String[] userInput = splitCourseInfo(rawInfo);
	}

	public String[] splitCourseInfo(String rawInfo) {
		String[] cleanInfo = rawInfo.split(", ");
		pairMatchingValidator.isValidInfo(cleanInfo);
		return cleanInfo;
	}
}
