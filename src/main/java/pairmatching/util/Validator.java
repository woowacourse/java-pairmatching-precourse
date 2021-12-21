package pairmatching.util;

import static pairmatching.constant.ErrorMessage.*;

import pairmatching.domain.Crew;
import pairmatching.domain.Curriculum;

public class Validator {
	public static void validateCrew(Object object) {
		if (!(object instanceof Crew)) {
			throw new IllegalArgumentException(NO_CREW_OBJECT);
		}
	}

	public static void validateCurriculumObject(Object object) {
		if (!(object instanceof Curriculum)) {
			throw new IllegalArgumentException(NO_CURRICULUM_OBJECT);
		}
	}

	public static void validateCurriculumInput(String input) {

	}
}
