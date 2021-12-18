package pairmatching.domain;

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
			.orElse(new Pairs(level, course, mission));
	}

	public void addPairsList(Pairs pairs) {
		pairsList.add(pairs);
	}

	public void test() {
		System.out.println();
	}
}
