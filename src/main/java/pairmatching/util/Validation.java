package pairmatching.util;

public class Validation {

	public static void matchingInfoLength(String text) {
		if (text.split(Constant.SPLIT).length != Constant.INPUT_SIZE) {
			throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_COURSE_AND_MISSION);
		}
	}
}
