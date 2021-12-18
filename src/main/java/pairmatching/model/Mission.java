package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public enum Mission {
	RACING_CAR("자동차경주"),
	LOTTO("로또"),
	BASEBALL_GAME("숫자야구게임"),
	SHOPPING_BASKET("장바구니"),
	PAYMENT("결제"),
	SUBWAY_MAP("지하철노선도"),
	PERFORMANCE_IMPROVEMENT("성능개선"),
	RELEASE("배포");

	private String name;

	Mission(String name) {
		this.name = name;
	}

	public static List<String> getMissionByLevel(String level) {
		List<String> missions = new ArrayList<>();
		if (level.equals("레벨1")) {
			missions.add(RACING_CAR.name);
			missions.add(LOTTO.name);
			missions.add(BASEBALL_GAME.name);
			return missions;
		}
		if (level.equals("레벨2")) {
			missions.add(SHOPPING_BASKET.name);
			missions.add(PAYMENT.name);
			missions.add(SUBWAY_MAP.name);
			return missions;
		}
		if (level.equals("레벨4")) {
			missions.add(PERFORMANCE_IMPROVEMENT.name);
			missions.add(RELEASE.name);
			return missions;
		}
		return missions;
	}
}
