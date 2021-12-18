package pairmatching.util;

import pairmatching.domain.Mission;

public class MissionValidator {
	public static boolean validate(String mission) {
		return mission.equals(Mission.RACING_CAR.getName())
			|| mission.equals(Mission.LOTTO.getName())
			|| mission.equals(Mission.BASEBALL.getName())
			|| mission.equals(Mission.SHOPPING_BASKET.getName())
			|| mission.equals(Mission.PAYMENT.getName())
			|| mission.equals(Mission.SUBWAY_PATH.getName())
			|| mission.equals(Mission.PERFORMANCE.getName())
			|| mission.equals(Mission.DEPLOYMENT.getName());
	}
}
