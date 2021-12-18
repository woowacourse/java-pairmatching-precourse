package pairmatching.domain;

import java.util.Arrays;

public enum FunctionMenu {
	PAIR_MATCHING("1", "페어 매칭" ),
	PAIR_FIND("2", "페어 조회" ),
	PAIR_INIT("3", "페어 초기화" ),
	QUIT("Q", "Q. 종료");

	public static final String ERROR_MESSAGE_NO_FUNCTION_MENU = "해당 하는 메뉴가 없습니다.";
	private final String selectedMenu;
	private final String name;

	FunctionMenu(String selectedMenu, String name) {
		this.selectedMenu = selectedMenu;
		this.name = name;
	}

	public static FunctionMenu findBySelectedMenu(String selectedMenu) {
		return Arrays.stream(FunctionMenu.values())
			.filter(e->e.selectedMenu.equals(selectedMenu))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_NO_FUNCTION_MENU));
	}
}
