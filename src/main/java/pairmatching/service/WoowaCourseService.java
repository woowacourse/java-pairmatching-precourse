package pairmatching.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import pairmatching.domain.Pair;
import pairmatching.domain.PairMatching;
import pairmatching.domain.WoowaCourse;
import pairmatching.repository.WoowaCourseRepository;

public class WoowaCourseService {

	private final WoowaCourseRepository woowaCourseRepository;

	public WoowaCourseService(WoowaCourseRepository woowaCourseRepository) {
		this.woowaCourseRepository = woowaCourseRepository;
	}

	public boolean isDuplicated(WoowaCourse woowaCourse) {
		Optional<Map.Entry<WoowaCourse, PairMatching>> one = findOne(woowaCourse);
		return one.isPresent();
	}

	public PairMatching matchAndEnroll(WoowaCourse woowaCourse) {
		PairMatchingService service = new PairMatchingService();
		List<Pair> pairs = service.pairMatch(woowaCourse);
		PairMatching pairMatching = new PairMatching(pairs);
		woowaCourseRepository.add(woowaCourse, pairMatching);
		return pairMatching;
	}

	public String getPairMatch(WoowaCourse woowaCourse) {
		Optional<Map.Entry<WoowaCourse, PairMatching>> one = findOne(woowaCourse);
		if (!one.isPresent()) {
			return "매칭된 결과가 없습니다.";
		}
		return one.get().getValue().toString();
	}

	private Optional<Map.Entry<WoowaCourse, PairMatching>> findOne(WoowaCourse woowaCourse) {
		return woowaCourseRepository.findOne(woowaCourse);
	}

	public void clearAll() {
		woowaCourseRepository.clearAll();
	}
}
