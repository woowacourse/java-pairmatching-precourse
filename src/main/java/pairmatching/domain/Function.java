package pairmatching.domain;

import java.util.Arrays;

public enum Function {
	MATCHING("1", "페어 매칭"),
	INQUIRY("2", "페어 조회"),
	INIT("3", "페어 초기화"),
	QUIT("Q", "종료");

	private static final String ERROR_NO_SUCH_FUNCTION = "존재하지 않는 기능입니다.";

	private String code;
	private String name;

	Function(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public static Function findByCode(String code) {
		return Arrays.stream(Function.values())
			.filter(function -> function.isCode(code))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NO_SUCH_FUNCTION));
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	private boolean isCode(String code) {
		return this.code.equals(code);
	}
}
