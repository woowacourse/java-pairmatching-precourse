package pairmatching.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairMatching {
	public List<String> backendCrew;
	public List<String> frontendCrew;
	public Set<Pair> pairSet;

	public PairMatching() {
		backendCrew = new ArrayList<String>();
		frontendCrew = new ArrayList<String>();
		pairSet = new HashSet<Pair>();
	}
}
