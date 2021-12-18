package pairmatching.model;

import java.util.List;
import java.util.Map;

import pairmatching.domain.Pair;

public class CleanUpService {
	public static void start(List<String> domainList) {
		Map<String, List<String>> pairMap = Pair.getInstance();
		pairMap.clear();
	}
}
