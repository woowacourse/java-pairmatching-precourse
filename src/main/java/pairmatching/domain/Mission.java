package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import pairmatching.exception.NotFoundMissionException;

public class Mission {
	Map<Level, List<String>> missions = new TreeMap<>();

	public Mission() {
		missions.put(Level.LEVEL1, Arrays.asList("자동차 경주", "로또", "숫자야구게임"));
		missions.put(Level.LEVEL2, Arrays.asList("장바구니", "결제", "지하철노선도"));
		missions.put(Level.LEVEL3, Collections.emptyList());
		missions.put(Level.LEVEL4, Arrays.asList("성능개선", "배포"));
		missions.put(Level.LEVEL5, Collections.emptyList());
	}

	public String findMissionName(Level level, String mission) {
		List<String> missionList = missions.get(level);
		if (missionList.contains(mission)) {
			return missionList.get(missionList.indexOf(mission));
		}
		throw new NotFoundMissionException();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Level, List<String>> levelListEntry : missions.entrySet()) {
			sb.append("	-	").append(levelListEntry.getKey()).append(": ");
			int count = 0;
			for (String mission : levelListEntry.getValue()) {
				if (count > 0) {
					sb.append(" | ");
				}
				sb.append(mission);
				count++;
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
