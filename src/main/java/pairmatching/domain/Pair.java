package pairmatching.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Pair {
	private Set<String> pair;

	public Pair() {
		pair = new HashSet<>();
	}

	public void add(String name) {
		pair.add(name);
	}

	/**
	 * 두 페어가 중복 크루를 매칭하고 있음을 검증하는 메서드
	 * @return 두 페어에 중복되는 크루가 두 명 이상 있으면 false, 그렇지 않다면 true
	 */
	public boolean duplicated(Pair other) {
		Set<String> combined = new HashSet<>(pair);
		combined.retainAll(other.getPair());

		return combined.size() >= 2;
	}

	public Set<String> getPair() {
		return Collections.unmodifiableSet(pair);
	}
}


