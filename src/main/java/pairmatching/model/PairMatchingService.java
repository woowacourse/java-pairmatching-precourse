package pairmatching.model;

import java.util.List;

public class PairMatchingService {
	public static final String PAIR_HISTORY_EXIST = "매칭 정보가 존재합니다.";
	private Course course;
	private Level level;
	private Crews crews;

	public PairMatchingService(Course course, Level level) {
		this.course = course;
		this.level = level;
	}

	public Pairs pairMatching() {
		List<String> shuffledCrewNames = CrewNames.create(course).shuffle();
		crews = Crews.create(course, shuffledCrewNames);

		Pairs pairs = Pairs.create(crews);
		validIsNotAlreadyPaired(pairs);

		PairMatchingRepository.save(pairs, level, course);

		return pairs;
	}

	private void validIsNotAlreadyPaired(Pairs pairs) {
		if (isAlreadyPaired(pairs)) {
			throw new IllegalArgumentException(PAIR_HISTORY_EXIST);
		}
	}

	private boolean isAlreadyPaired(Pairs pairs) {
		return pairs.get().stream()
			.anyMatch(pair -> PairMatchingRepository.isAlreadyPaired(pair, level, course));
	}

}
