package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pairmatching.util.SystemMessage;

public class MissionRepository {
	private final Map<Level, List<Mission>> missions = new LinkedHashMap<Level, List<Mission>>() {
		{
			put(Level.LEVEL1, Arrays.asList(Mission.RACING_CAR, Mission.LOTTO, Mission.BASEBALL));
			put(Level.LEVEL2, Arrays.asList(Mission.SHOPPING_BASKET, Mission.PAYMENT, Mission.SUBWAY_PATH));
			put(Level.LEVEL3, Collections.emptyList());
			put(Level.LEVEL4, Arrays.asList(Mission.PERFORMANCE, Mission.DEPLOYMENT));
			put(Level.LEVEL5, Collections.emptyList());
		}
	};

	public String getMissionListString() {
		List<String> missionStrings = new ArrayList<>();
		for (Level level : missions.keySet()) {
			String missionString = SystemMessage.MISSION_LIST + level.getName() + ": ";
			List<Mission> missionListByLevel = missions.get(level);
			String missionListString = missionListByLevel.stream()
				.map(Mission::getName)
				.collect(Collectors.joining(" | "));
			missionString += missionListString;
			missionStrings.add(missionString);
		}

		return String.join("\n", missionStrings);
	}
}
