package pairmatching.domain;

import static pairmatching.enums.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class PairRepository {
	private List<Pairs> pairsList = new ArrayList<>();

	public PairRepository() {
	}

	public boolean hasPairs(Level level, Course course, String mission) {
		return pairsList.stream()
			.anyMatch(p -> p.find(level, course, mission));
	}

	public Pairs getPairs(Level level, Course course, String mission) {
		return pairsList.stream()
			.filter(p -> p.find(level, course, mission))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(NO_HAS_PAIRS_ERROR.get()));
	}

	public void addPairsList(Pairs pairs) {
		pairsList.add(pairs);
	}

	public void init() {
		pairsList = new ArrayList<>();
	}
}
