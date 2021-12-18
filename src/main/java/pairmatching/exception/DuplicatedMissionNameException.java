package pairmatching.exception;

public class DuplicatedMissionNameException extends IllegalArgumentException {
	public static final String ERROR_MESSAGE_FOR_DUPLICATED_MISSION_NAME = "[ERROR] 중복된 미션 이름이 있습니다 :(";

	public DuplicatedMissionNameException() {
		super(ERROR_MESSAGE_FOR_DUPLICATED_MISSION_NAME);
	}
}
