package pairmatching.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatching;
import pairmatching.domain.WoowaCourse;
import pairmatching.repository.WoowaCourseRepository;

// todo : 같은 레벨에서 이미 페어를 맺은 크루와는 다시 페어로 매칭될 수 없다.
// todo : 3회 시도까지 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없으면 에러메시지를 출력한다.
public class PairMatchingService {

	private static final int MAX_TRIAL = 3;
	private static final String ERROR_MATCH = "매칭에 실패하였습니다.";

	private final WoowaCourseRepository repository;

	public PairMatchingService(WoowaCourseRepository repository) {
		this.repository = repository;
	}

	public List<Pair> pairMatch(WoowaCourse woowaCourse) {
		List<String> load = woowaCourse.loadCrewInfo();
		int trial = 0;
		while (trial < MAX_TRIAL) {
			List<Pair> pairs = shuffleAndMatch(load);
			if (isPairMatchable(pairs, woowaCourse)) {
				return pairs;
			}
			trial++;
		}
		throw new IllegalArgumentException(ERROR_MATCH);
	}

	private boolean isPairMatchable(List<Pair> pairs, WoowaCourse woowaCourse) {
		Map<WoowaCourse, PairMatching> map = repository.get();
		return map.entrySet().stream()
			.filter(entry -> entry.getKey().isSameLevel(woowaCourse) && !entry.getKey().equals(woowaCourse))
			.allMatch(entry -> isPairNotDuplicated(entry.getValue(), pairs));
	}

	private boolean isPairNotDuplicated(PairMatching pairMatching, List<Pair> candidates) {
		for (Pair candidate : candidates) {
			if (pairMatching.contains(candidate)) {
				return false;
			}
		}
		return true;
	}

	private List<Pair> shuffleAndMatch(List<String> load) {
		List<String> shuffle = Randoms.shuffle(load);
		List<Crew> collect = shuffle.stream().map(Crew::new).collect(Collectors.toList());
		return doMatch(collect);
	}

	private List<Pair> doMatch(List<Crew> crews) {
		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < crews.size() - 1; i += 2) {
			Crew firstCrew = crews.get(i);
			Crew secondCrew = crews.get(i + 1);
			pairs.add(new Pair(Arrays.asList(firstCrew, secondCrew)));
		}
		addLastIfCrewNumberOdd(crews, pairs);
		return pairs;
	}

	private void addLastIfCrewNumberOdd(List<Crew> shuffle, List<Pair> pairs) {
		if (shuffle.size() % 2 != 0) {
			pairs.get(pairs.size() - 1).add(shuffle.get(shuffle.size() - 1));
		}
	}
}
