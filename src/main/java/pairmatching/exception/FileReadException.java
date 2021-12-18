package pairmatching.exception;

import pairmatching.view.output.ErrorMessage;

public class FileReadException extends PairMatchingException {

	public FileReadException() {
		super(ErrorMessage.FILE_CANNOT_READ_MESSAGE);
	}

}
