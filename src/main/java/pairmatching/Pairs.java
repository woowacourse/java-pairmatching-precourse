package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pairs {
	List<String[]> pairs;
	public boolean isnull;
	public Pairs(List<String[]> pairs) {
		this.pairs = pairs;
		isnull = false;
	}
	public Pairs() {
		isnull = true;
	}
	public boolean checkPair(List<String[]> pairs) {
		for (String[] pairA : this.pairs) {
			for (String[] pairB : pairs) {
				List<String> result = new ArrayList<>(3);
				result.addAll(Arrays.asList(pairA));
				result.retainAll(Arrays.asList(pairB));
				if (result.size() >= 2) {
					return false;
				}
			}
		}
		return true;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String[] pair: pairs) {
			sb.append(String.join(" : ", pair)).append("\n");
		}
		return sb.toString();
	}
}
