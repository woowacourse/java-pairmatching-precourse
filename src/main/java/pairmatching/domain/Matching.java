package pairmatching.domain;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Matching {
	Map<Level, List<Pairs>> pairsMap = new TreeMap<>();

	public void add(Level level, List<Pairs> pairs) {
		pairsMap.put(level, pairs);
	}

	@Override
	public String toString() {
		StringBuilder stringBuffer = new StringBuilder();
		for (List<Pairs> levelListEntry : pairsMap.values()) {
			stringBuffer.append(levelListEntry);
		}
		return stringBuffer.toString();
	}

}
