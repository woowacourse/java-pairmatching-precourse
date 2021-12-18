package pairmatching.model;

import java.util.HashMap;
import java.util.Map;

public class PairListMap {

	private Map<PairInfo, PairList> pairListMap;

	public PairListMap() {
		pairListMap = new HashMap<>();
	}

	public PairList getPairList(PairInfo pairInfo) {
		return pairListMap.getOrDefault(pairInfo, null);
	}

	public void save(PairInfo pairInfo, PairList pairList) {
		pairListMap.put(pairInfo, pairList);
	}

	public int size() {
		return pairListMap.size();
	}

	public boolean contains(PairInfo pairInfo) {
		return pairListMap.containsKey(pairInfo);
	}

	public void initialize() {
		pairListMap = new HashMap<>();
	}
}
