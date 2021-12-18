package pairmatching.view;

import pairmatching.domain.Level;
import pairmatching.service.MissionService;

public class OutputView {
	private static final String ERROR = "[ERROR]";

	public static void printExceptionMessage(String message) {
		System.out.println(ERROR + message);
	}

	public static void printStatus(MissionService missionService) {
		System.out.println("\n#############################################");
		System.out.println("과정: 백엔드 | 프론트엔드");
		System.out.println("미션");
		for (Level value : Level.values()) {
			System.out.print("  - " + value.getLevel() + ": ");
			System.out.println(String.join(" | ", missionService.getMissionNamesByLevel(value)));
		}
		System.out.println("#############################################");
	}

	public static void printInitializeMessage() {
		System.out.println("초기화 되었습니다.");
	}
}
