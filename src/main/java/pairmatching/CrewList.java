package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CrewList {
	private final Course course;
	private final List<Crew> crews;

	public CrewList(Course course) {
		this.course = course;
		this.crews = new ArrayList<>();
	}

	public void addCrew(Crew crew) {
		if (crew.isCourse(course)) {
			crews.add(crew);
		}
		// 에러 메세지 출력
	}

	public PairList doPairMatching() {
		List<Crew> shuffledCrews = Randoms.shuffle(crews);
		if (shuffledCrews.size() % 2 == 0) {
			return doEvenPairMatching(shuffledCrews);
		}
		return doOddPairMatching(shuffledCrews);
	}

	private PairList doOddPairMatching(List<Crew> shuffledCrews) {
		PairList pairList = new PairList();
		for (int i = Constants.ONE; i < shuffledCrews.size(); i += 2) {
			List<Crew> input = Arrays.asList(shuffledCrews.get(i), shuffledCrews.get(i - Constants.ONE));
			Pair pair = new Pair(input);
			pairList.add(pair);
		}
		return pairList;
	}

	private PairList doEvenPairMatching(List<Crew> shuffledCrews) {
		PairList pairList = new PairList();
		int crewListSize = shuffledCrews.size();
		pairList.add(new Pair(Arrays.asList(
			shuffledCrews.get(crewListSize - Constants.ONE),
			shuffledCrews.get(crewListSize - Constants.TWO),
			shuffledCrews.get(crewListSize - Constants.THREE))));
		for (int i = Constants.ONE; i < shuffledCrews.size() - Constants.THREE; i += 2) {
			pairList.add(new Pair(Arrays.asList(shuffledCrews.get(i), shuffledCrews.get(i - Constants.ONE))));
		}
		return pairList;
	}
}
