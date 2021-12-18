package pairmatching.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Pair {
	private static final Map<String, List<String>> pairMap = new LinkedHashMap<>();

	public static Map<String, List<String>> getInstance() {
		return pairMap;
	}

	public static void setMatchedPair(List<String> domainList, List<String> pairList) {
		String domain = String.join("", domainList);
		pairMap.put(domain, pairList);
	}

	public static boolean isAlreadyMatched(List<String> domainList) {
		return pairMap.keySet().stream()
			.anyMatch(mission -> mission.equals(String.join("", domainList)));
	}

	public static Map<String, List<String>> create(List<String> domainList, List<String> crews) {
		int index = 0;
		String domain = String.join("", domainList);
		initialSetting(domain);
		while (index < crews.size() - 1) {
			String pair = crews.get(index++) + " : " + crews.get(index++);
			pairMap.get(domain).add(pair);
		}
		if (index == crews.size() - 1) {
			String lastPair = pairMap.get(domain).get(pairMap.size() - 1);
			pairMap.get(domain).set(pairMap.size() - 1, lastPair + " : " + crews.get(index));
		}
		return pairMap;
	}

	private static void initialSetting(String domain) {
		pairMap.putIfAbsent(domain, new ArrayList<>());
	}
}
