package pairmatching.exception;

public class DuplicatedCrewNameException extends IllegalArgumentException {
	public static final String ERROR_MESSAGE_FOR_DUPLICATED_CREW_NAME = "[ERROR] 중복된 크루 이름이 있습니다 :(";

	public DuplicatedCrewNameException() {
		super(ERROR_MESSAGE_FOR_DUPLICATED_CREW_NAME);
	}
}
