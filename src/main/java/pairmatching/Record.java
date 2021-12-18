package pairmatching;

import java.util.HashMap;
import java.util.Map;

public class Record {
	private final Map<String, PairList> record;

	public Record() {
		record = new HashMap<>();
	}

	public void push(String mission, PairList pairList) {
		record.put(mission, pairList);
	}

	public PairList get(String mission) {
		return record.get(mission);
	}
}

