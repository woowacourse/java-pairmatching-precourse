package pairmatching.validator;

public class PairMatchingValidator {
	public void isValidInput(String rawInfo) {
		if (!rawInfo.contains(", ")) {
			throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 형식: ");
		}
	}

	public void isValidInfo(String[] cleanInfo) {
		isValidLength(cleanInfo);
		isValidCourseName(cleanInfo[0]);
		isValidLevel(cleanInfo[1]);
		isValidMission(cleanInfo[2]);
	}

	public void isValidLength(String[] cleanInfo) {
		if (cleanInfo.length != 3) {
			throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
		}
	}

	public void isValidCourseName(String courseName) {
		//
	}

	public void isValidLevel(String level) {

	}

	public void isValidMission(String mission) {

	}

}
