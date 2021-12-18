package pairmatching.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainMenu {
	private Map<String, String> menuMap = new LinkedHashMap<>();

	public MainMenu() {
		initMenuMap();
	}

	private void initMenuMap() {
		menuMap.put("1", "1. 페어 매칭");
		menuMap.put("2", "2. 페어 조회");
		menuMap.put("3", "3. 페어 초기화");
		menuMap.put("Q", "Q. 종료");
	}

	public void printMainMenus() {
		for (String menuKey: menuMap.keySet()) {
			System.out.println(menuMap.get(menuKey));
		}
	}
}
