package pairmatching.utils;

public enum MyRegex {
	ONLY_KOREAN_AND_ENGLISH("^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+$");
	private final String regexPattern;

	MyRegex(String regexPattern) {
		this.regexPattern = regexPattern;
	}

	public String getRegexPattern() {
		return this.regexPattern;
	}
}
