package pairmatching.domain;

import java.util.HashMap;

public class PairStorage {
	public HashMap<Level, HashMap<String, Pairs>> backEndPair = new HashMap<>();
	public HashMap<Level, HashMap<String, Pairs>> frontEndPair = new HashMap<>();
}
