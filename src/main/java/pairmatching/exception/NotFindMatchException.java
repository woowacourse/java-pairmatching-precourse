package pairmatching.exception;

public class NotFindMatchException extends IllegalArgumentException{

	static final String NOT_FIND_MATCH = "매칭 이력이 없습니다.";

	public NotFindMatchException(){
		super(NOT_FIND_MATCH);
	}
}
