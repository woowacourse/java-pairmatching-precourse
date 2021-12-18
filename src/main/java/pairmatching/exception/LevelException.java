package pairmatching.exception;

public class LevelException extends IllegalArgumentException {

	static final String NOT_FIND_LEVEL = "입력하신 레벨이 없습니다.";

	public LevelException() {
		super(NOT_FIND_LEVEL);
	}
}
