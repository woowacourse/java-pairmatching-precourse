package pairmatching;

import java.io.IOException;

public class Pairmatching {
	private static final int PAIRMATCHING = 1;
	private static final int PAIRMATCHINGINFO = 2;
	private static final int CLEAR = 3;
	private static final int QUIT = 4;

	public static void start() throws IOException {
		selectMenu();
	}

	private static void selectMenu() throws IOException {
		while (true) {
			String selectedMenu = Input.inputMenu();
			if (Integer.parseInt(selectedMenu) == PAIRMATCHING) {
				String[] CourseLevelMission = Input.inputCourseLevelMission();
				Crews.matchCrews();
			}
			if (Integer.parseInt(selectedMenu) == PAIRMATCHINGINFO) {
				Input.pairmatchingInfo();
			}
			if (Integer.parseInt(selectedMenu) == CLEAR) {
				Crews.clear();
			}
			if (Integer.parseInt(selectedMenu) == QUIT) {
				break;
			}
		}
	}
}
