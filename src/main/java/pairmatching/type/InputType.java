package pairmatching.type;

public enum InputType {
	SPLIT(",");

	private String string;

	InputType(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}
}
