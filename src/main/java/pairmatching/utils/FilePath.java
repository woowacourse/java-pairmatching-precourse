package pairmatching.utils;

public enum FilePath {
	BACK_END_FILE_ADDRESS("src/main/resources/backend-crew.md"),
	FRONT_END_FILE_ADDRESS("src/main/resources/frontend-crew.md");
	private final String address;

	FilePath(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}
}
