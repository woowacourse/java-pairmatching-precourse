package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
	List<String> names = new ArrayList<>();

	public Pair(String name1, String name2) {
		names.add(name1);
		names.add(name2);
	}

	public void add(String name) {
		names.add(name);
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < names.size(); i++) {
			if (i == names.size() - 1) {
				result += (names.get(i));
				continue;
			}
			result += (names.get(i) + " : ");
		}
		return result;
	}

	public boolean isExistPair(Pair pair) {
		boolean check = true;
		for (String name : pair.names) {
			if (!names.contains(check)) {
				check = false;
			}
		}
		return check;
	}
}
