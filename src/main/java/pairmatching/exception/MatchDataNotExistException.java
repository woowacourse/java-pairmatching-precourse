package pairmatching.exception;

import pairmatching.view.output.ErrorMessage;

public class MatchDataNotExistException extends PairMatchingException {

	public MatchDataNotExistException() {
		super(ErrorMessage.MATCH_DATA_NOT_EXIST_MESSAGE);
	}

}
