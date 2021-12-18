package pairmatching.Model.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import pairmatching.Controller.Controller;
import pairmatching.Controller.MainController;
import pairmatching.Controller.subcontroller.InquiryController;
import pairmatching.Controller.subcontroller.MatchingController;

public enum MainMenu {
	PAIR_MATCHING("1", "1. 페어 매칭", new MatchingController()),
	PAIR_INQUIRY("2", "2. 페어 조회", new InquiryController()),
	PAIR_RESET("3", "3. 페어 초기화", MainController::resetPair),
	QUIT("Q", "Q. 종료", null);

	private String button;
	private String menu;
	private Controller controller;

	MainMenu(String button, String menu, Controller controller) {
		this.button = button;
		this.menu = menu;
		this.controller = controller;
	}

	public static List<String> list() {
		return Arrays.stream(MainMenu.values()).map(m -> m.menu).collect(Collectors.toList());
	}

	public static MainMenu fineMenu(String menuName) {
		return Arrays.stream(MainMenu.values())
			.filter(m -> m.button.equals(menuName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 메뉴 입력입니다!"));
	}

	public boolean isRunning() {
		if (!Objects.equals(this, QUIT)) {
			return true;
		}
		return false;
	}

	public static MainMenu setRunningState() {
		return PAIR_MATCHING;
	}

	public void start() {
		this.controller.run();
	}

}
