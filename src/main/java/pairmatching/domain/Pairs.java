package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import pairmatching.utils.Util;

public class Pairs {
	private final List<Pair> pairList = new ArrayList<>();
	public List<String> nameList;

	public Pairs(List<String> nameList) {
		this.nameList = nameList;
		setPairs();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Pair pair : pairList) {
			result.append(pair).append("\n");
		}
		return result.toString();
	}

	public void setPairs() {
		nameList = Util.shuffle(nameList);

		for (int i = 0; i < nameList.size() - 1; i += 2) {
			pairList.add(new Pair(nameList.get(i), nameList.get(i + 1)));
		}
		if (nameList.size() % 2 == 0) {
			setEvenPairs();
		}
		if (nameList.size() % 2 == 1) {
			setOddPairs();
		}
	}

	private void setOddPairs() {
		pairList.get(pairList.size() - 1)
			.setThreePair(nameList.get(nameList.size() - 1));
	}

	private void setEvenPairs() {
		pairList.add(new Pair(nameList.get(nameList.size() - 2), nameList.get(nameList.size() - 1)));
	}

	public HashSet<String> findPair(String name) {
		for (Pair pair : pairList) {
			if (pair.isInPair(name)) {
				return pair.get();
			}
		}
		return null;
	}
}
