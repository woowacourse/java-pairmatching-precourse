package pairmatching.util;

import static pairmatching.domain.Course.*;
import static pairmatching.domain.Level.*;

import pairmatching.view.ErrorMessage;

public class DomainValidator {

	public static final String DOMAIN_SEPARATOR = ", ";

	public static void validateInputForm(String inputString) {
		String[] domains = inputString.split(DOMAIN_SEPARATOR);
		validateCourse(domains[0]);
		validateLevel(domains[1]);
		validateMission(domains[1], domains[2]);
	}

	private static void validateCourse(String inputCourse) {
		if (!isExistingCourse(inputCourse)) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_COURSE);
		}
	}

	private static void validateLevel(String inputLevel) {
		if (!isExistingLevel(inputLevel)) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_LEVEL);
		}
	}

	private static void validateMission(String level, String inputMission) {
		if (!isExistingMission(level, inputMission)) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MISSION);
		}
	}
}
