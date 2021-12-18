package pairmatching.domain.repository;

import static pairmatching.utils.Constants.*;
import static pairmatching.utils.ExceptionMessage.*;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Mission;

public class MissionRepository {
	public static List<Mission> missionList = new ArrayList<>();

	static {
		missionList.add(new Mission(CAR_MISSION));
		missionList.add(new Mission(LOTTO_MISSION));
		missionList.add(new Mission(BASE_BALL_MISSION));
		missionList.add(new Mission(SHOPPING_CART_MISSION));
		missionList.add(new Mission(PAYMENT_MISSION));
		missionList.add(new Mission(SUBWAY_MAP_MISSION));
	}

	public static Mission findMission(String name) {
		return missionList.stream()
			.filter(mission -> mission.isSame(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(EXCEPTION_INPUT_MISSION));
	}
}
