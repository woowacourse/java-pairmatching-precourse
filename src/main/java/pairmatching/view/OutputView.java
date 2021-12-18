package pairmatching.view;

import pairmatching.domain.Level;
import pairmatching.service.MissionService;

public class OutputView {
	public static void printStatus(MissionService missionService) {
		System.out.println("#############################################");
		System.out.println("과정: 백엔드 | 프론트엔드");
		System.out.println("미션");
		for (Level value : Level.values()) {
			System.out.print("  - 레벨" + value.getLevel() + ": ");
			System.out.println(String.join(" | ", missionService.getMissionsByLevel(value)));
		}
		System.out.println("#############################################");
	}
}
