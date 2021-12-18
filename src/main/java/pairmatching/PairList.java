package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class PairList {
	private final List<Pair> list;

	public PairList() {
		list = new ArrayList<>();
	}

	public void add(Pair pair) {
		list.add(pair);
	}

	public Pair get(int index) {
		return list.get(index);
	}

	public int size() {
		return list.size();
	}

	public boolean hasDuplicate(PairList counterPart) {
		if (counterPart == null) {
			return false;
		}

		for (Pair value : list) {
			if (counterPart.contains(value)) {
				return true;
			}
		}
		return false;
	}

	private boolean contains(Pair pair) {
		for (Pair value : list) {
			if (value.equals(pair)) {
				return true;
			}
		}
		return false;
	}

}
