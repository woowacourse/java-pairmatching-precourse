package pairmatching.common;

public enum RematchOption {
	YES("네"),
	NO("아니오");

	private final String option;

	RematchOption(String option) {
		this.option = option;
	}

	public String getOption() {
		return option;
	}
}
