package pairmatching.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MatchingInfo {
	private Map<String, List<Pair>> matchingInfo;

	public MatchingInfo() {
		matchingInfo = new LinkedHashMap<>();
	}
}
