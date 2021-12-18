package pairmatching.domain;

import java.util.LinkedHashSet;

public class Pair {

	private LinkedHashSet<String> names;

	@Override
	public String toString() {
		return String.join(" : ", names.toArray(new String[0]));
	}
}
