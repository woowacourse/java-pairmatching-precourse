package pairmatching.model;

import java.util.Map;

public class PairListMap {

	private Map<PairInfo, PairList> pairListMap;

	public void save(PairInfo pairInfo, PairList pairList) {
		pairListMap.put(pairInfo, pairList);
	}
}
