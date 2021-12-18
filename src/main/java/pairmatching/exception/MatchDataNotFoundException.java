package pairmatching.exception;

import pairmatching.view.output.ErrorMessage;

public class MatchDataNotFoundException extends PairMatchingException {

	public MatchDataNotFoundException() {
		super(ErrorMessage.MATCH_DATA_NOT_FOUND_MESSAGE);
	}

}
