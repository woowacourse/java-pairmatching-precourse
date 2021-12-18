package pairmatching.util;

public enum ViewMessage {
	INPUT_MACHINE_MONEY("");


	private final String message;

	ViewMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
