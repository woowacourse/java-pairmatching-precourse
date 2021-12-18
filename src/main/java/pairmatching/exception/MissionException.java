package pairmatching.exception;

public class MissionException extends IllegalArgumentException{

	static final String NOT_FIND_MISSION = "입력하신 미션이 없습니다.";

	public MissionException(){
		super(NOT_FIND_MISSION);
	}
}
