package pairmatching.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.WoowaCourse;

public class PairMatchingService {
	// todo : 3명 페어 매칭
	// todo : 같은 레벨에서 이미 페어를 맺은 크루와는 다시 페어로 매칭될 수 없다.
	// todo : 3회 시도까지 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없으면 에러메시지를 출력한다.
	public List<Pair> pairMatch(WoowaCourse woowaCourse) {
		List<String> load = woowaCourse.load();
		List<String> shuffle = Randoms.shuffle(load);
		List<Crew> collect = shuffle.stream().map(Crew::new).collect(Collectors.toList());
		List<Pair> pairs = doMatch(collect);
		return pairs;
	}

	private List<Pair> doMatch(List<Crew> shuffle) {
		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < shuffle.size() - 1; i += 2) {
			Crew firstCrew = shuffle.get(i);
			Crew secondCrew = shuffle.get(i + 1);
			pairs.add(new Pair(Arrays.asList(firstCrew, secondCrew)));
		}
		return pairs;
	}
}
