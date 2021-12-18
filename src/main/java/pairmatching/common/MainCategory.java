package pairmatching.common;

public enum MainCategory {
	MATCH("1", "페어 매칭"),
	RETRIEVE("2", "페어 조회"),
	RESET("3", "페어 초기화"),
	EXIT("Q", "종료");

	private String category;
	private String description;

	MainCategory(String category, String description) {
		this.category = category;
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}
}

