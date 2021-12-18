package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.utils.FileUtils;

public class Matching {
	private static String REGEX = ", ";
	private static int ONE = 1;
	private static String LINE_WRAP = "\n";
	private Course course;
	private Level level;
	private List<Pair> pairs;

	public Matching(String inputMatchingCondition) {
		String[] matchingCondition = inputMatchingCondition.split(REGEX);
		this.course = Course.of(matchingCondition[0]);
		this.level = Level.of(matchingCondition[1]);
		this.pairs = new ArrayList<>();
	}

	public void matchPairs() {
		List<String> shuffledCrew = Randoms.shuffle(FileUtils.readFile(course.getName()));
		int index = 0;
		while (index < shuffledCrew.size()) {
			Pair pair = new Pair();
			pair.addName(shuffledCrew.get(index++));
			pair.addName(shuffledCrew.get(index++));
			if (shuffledCrew.size() % 2 == 1 && index == shuffledCrew.size() - ONE) {
				pair.addName(shuffledCrew.get(index++));
			}
			pairs.add(pair);
		}
	}

	@Override
	public String toString() {
		StringBuilder pairStringBuilder = new StringBuilder();
		for (Pair pair : pairs) {
			pairStringBuilder.append(pair.toString()).append(LINE_WRAP);
		}
		return pairStringBuilder.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		Matching matching = (Matching)o;
		return course == matching.course && level == matching.level;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level);
	}
}
