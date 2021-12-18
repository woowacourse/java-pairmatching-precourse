package pairmatching.exception;

import pairmatching.view.output.ErrorMessage;

public class MissionNotFoundException extends PairMatchingException {

	public MissionNotFoundException() {
		super(ErrorMessage.MISSION_NOT_FOUND_MESSAGE);
	}

}
