package pairmatching.resource;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PairMachList {
	private static PairMachList pairMachList = new PairMachList();

	private static Map<String, Map<String, Map<String, List<List<List<String>>>>>> pairMap;

	private PairMachList() {}

	public static PairMachList getInstance() {
		return pairMachList;
	}

	private void initializePairMap(Map<String, List<String>> missionMap) {
		for (String course : Course.toList()) {
			pairMap.put(course, new LinkedHashMap<>());
			appendLevelMap(pairMap.get(course));
		}
	}

	private void appendLevelMap(Map<String, Map<String, List<List<List<String>>>>> courseMap) {
		for (String level : Level.toList()) {
			courseMap.put(level, new List<List<List<String>>>());
		}
	}

		pairMap.
	}
