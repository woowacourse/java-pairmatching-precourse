package pairmatching.domain;

import java.util.List;

public class PairsRecord {
	private List<Pairs> records;

	public PairsRecord() {
	}

	public void add(Pairs pairs) {
		records.add(pairs);
	}

	public boolean isExistent(List<String> condition) {
		for (Pairs record : records) {
			if (record.getCondition() == condition) {
				return true;
			}
		}
		return false;
	}

	// public Pair getPairByCondition(List<String> condition) {
	// 	return pairs.stream().filter((p) -> condition.equals(p.getCondition())).findFirst().get();
	// }
}
