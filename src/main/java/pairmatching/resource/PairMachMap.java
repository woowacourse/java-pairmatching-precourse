package pairmatching.resource;

import static pairmatching.constants.ProgramConstants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class PairMachMap {
	private static final PairMachMap pairMachMap = new PairMachMap();

	private static Map<String, Map<String, Map<String, List<List<Crew>>>>> pairMap;

	private PairMachMap() {
		initializePairMap();
	}

	public static PairMachMap getInstance() {
		return pairMachMap;
	}

	public void resetMap() {
		initializePairMap();
	}

	private void initializePairMap() {
		for (String course : Course.toList()) {
			pairMap.put(course, new LinkedHashMap<>());
			appendLevelMap(pairMap.get(course));
		}
	}

	private void appendLevelMap(Map<String, Map<String, List<List<Crew>>>> courseMap) {
		for (String level : Level.toList()) {
			courseMap.put(level, new HashMap<>());
			appendMissionList(courseMap.get(level), level);
		}
	}

	private void appendMissionList(Map<String, List<List<Crew>>> missionMap, String level) {
		for (String mission : MISSION_MAP.get(level)) {
			missionMap.put(mission, new ArrayList<>());
		}
	}

	public boolean createPair(List<String> targetSelection) {
		List<List<Crew>> pairList = getRandomPairs();
		pairMap.get(targetSelection.get(0))
				.get(targetSelection.get(1))
				.get(targetSelection.get(2)).addAll(pairList);
		return true;
	}

	private List<List<Crew>> getRandomPairs() {
		List<List<Crew>> pairList = new ArrayList<>();
		List<Crew> shuffledList = Randoms.shuffle(Crew.getBackendCrew());
		for (int i = 0; i < shuffledList.size(); i += 2) {
			pairList.add(Arrays.asList(shuffledList.get(i), shuffledList.get(i + 1)));
		}
		return pairList;
	}
}
