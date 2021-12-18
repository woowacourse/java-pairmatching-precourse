package pairmatching.domain;

import java.util.List;

public class Pairs {
	public List<Pair> pairs;

	public List<Pair> getPairList() {
		return pairs;
	}

	public Pairs(List<Pair> pairs) {
		this.pairs = pairs;
	}

	public boolean contains(Pair pair) {
		return pairs.contains(pair);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("페어 매칭 결과입니다.").append("\n");
		for (Pair pair : pairs) {
			stringBuilder.append(pair.toString());
		}
		return stringBuilder.toString();
	}
}
