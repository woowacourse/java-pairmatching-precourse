package pairmatching.domain;

import static constants.PairMatchingConstants.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class CrewPair {
	public Map<Pair<Course, Mission>, List<String>> pairs;

	public CrewPair() {
		pairs = new HashMap<>();
	}

	public boolean isExist(Pair<Course, Mission> info) {
		return pairs.get(info) != null;
	}

	public void addPair(Pair<Course, Mission> info, List<String> crews) {
		for (Pair<Course, Mission> key : pairs.keySet()) {
			if (key.getKey() == info.getKey() && key.getValue().getLevel() == key.getValue().getLevel()) {
				checkCrews(pairs.get(key), crews);
			}
		}
		pairs.put(info, crews);
	}

	private void checkCrews(List<String> existCrews, List<String> newCrews) {
		int idx = 0;
		for (; idx < existCrews.size() - 2; idx += 2) {
			if (existCrews.get(idx).equals(newCrews.get(idx)) && existCrews.get(idx + 1)
				.equals(newCrews.get(idx + 1))) {
				throw new IllegalArgumentException(MATCHING_DUPLICATE);
			}
		}
		if (existCrews.size() % 2 == 0) {
			checkEvenNumberOfCrews(existCrews, newCrews);
		}
		if (existCrews.size() % 2 == 1) {
			checkOddNumberOfCrews(existCrews, newCrews);
		}
	}

	private void checkEvenNumberOfCrews(List<String> existCrews, List<String> newCrews) {
		if (existCrews.get(existCrews.size() - 1).equals(newCrews.get(existCrews.size() - 1)) && existCrews.get(
			existCrews.size() - 2)
			.equals(newCrews.get(existCrews.size() - 2))) {
			throw new IllegalArgumentException(MATCHING_DUPLICATE);
		}
	}

	private void checkOddNumberOfCrews(List<String> existCrews, List<String> newCrews) {
		if (existCrews.get(existCrews.size() - 1).equals(newCrews.get(existCrews.size() - 1)) && existCrews.get(
			existCrews.size() - 2)
			.equals(newCrews.get(existCrews.size() - 2)) && existCrews.get(existCrews.size() - 3)
			.equals(newCrews.get(existCrews.size() - 3))) {
			throw new IllegalArgumentException(MATCHING_DUPLICATE);
		}
	}

	public List<String> getPair(Pair<Course, Mission> info) {
		if (pairs.get(info) == null) {
			throw new IllegalArgumentException(CAN_NOT_FIND_PAIR_ERROR);
		}
		return pairs.get(info);
	}

	public void resetPair() {
		pairs.clear();
	}
}