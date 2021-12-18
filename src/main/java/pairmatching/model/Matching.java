package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.utils.FileUtils;

public class Matching {
	private Course course;
	private Level level;
	private List<Pair> pairs;

	public Matching(String inputMatchingCondition) {
		String[] matchingCondition = inputMatchingCondition.split(", ");
		this.course = Course.of(matchingCondition[0]);
		this.level = Level.of(matchingCondition[1]);
		this.pairs = new ArrayList<>();
		matchPairs(matchingCondition[0]);
	}

	private void matchPairs(String courseName) {
		List<String> shuffledCrew = Randoms.shuffle(FileUtils.readFile(courseName));
		int index = 0;
		while (index < shuffledCrew.size()) {
			Pair pair = new Pair();
			pair.addName(shuffledCrew.get(index++));
			pair.addName(shuffledCrew.get(index++));
			if (shuffledCrew.size() % 2 == 1 && index == shuffledCrew.size() - 1) {
				pair.addName(shuffledCrew.get(index++));
			}
			pairs.add(pair);
		}
	}
}
