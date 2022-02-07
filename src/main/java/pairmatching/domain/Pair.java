package pairmatching.domain;

import java.util.HashSet;
import java.util.Objects;

public class Pair {
	private final HashSet<String> pair = new HashSet<>();

	public Pair(String pairOne, String pairTwo) {
		this.pair.add(pairOne);
		this.pair.add(pairTwo);
	}

	public void setThreePair(String name) {
		pair.add(name);
	}

	public HashSet<String> get() {
		return pair;
	}

	public boolean isInPair(String name) {
		return pair.contains(name);
	}

	@Override
	public boolean equals(Object obj) {
		// 모델값 같은지 확인
		return this == obj || (obj instanceof Pair && this.hashCode() == obj.hashCode());
	}

	@Override
	public String toString() {
		// 프린트 원하는 방식으로 구현
		if (pair.size() == 2) {
			return pair.toString();
		}
		return pair.toString();
	}

	@Override
	public int hashCode() {
		// 같은 객체인지 판별하는 기준
		return Objects.hashCode(this.toString());
	}
}
