package pairmatching.application;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.model.Crew;
import pairmatching.model.CrewRepository;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.MissionRepository;
import pairmatching.model.Pair;
import pairmatching.model.PairRepository;

public class PairGenerator {
	public List<Pair> generate(Mission mission) {
		int count = 0;

		while (count < 3) {
			List<Pair> pairList = generatePairList(mission);

			if (isValidPairList(mission, pairList)) {
				return pairList;
			}

			count++;
		}

		throw new IllegalStateException("매칭에 실패했습니다.");
	}

	private List<Pair> generatePairList(Mission mission) {
		List<Crew> shuffledCrew = Randoms.shuffle(CrewRepository.findAll());
		List<Pair> result = new ArrayList<>();

		for (int index = 0; index < shuffledCrew.size(); index += 2) {
			result.add(createPair(mission, shuffledCrew, index));
			if (shuffledCrew.size() - index == 3) {
				break;
			}
		}

		return result;
	}

	private boolean isValidPairList(Mission mission, List<Pair> pairList) {
		Level level = mission.getLevel();
		List<Mission> sameLevelMissions = MissionRepository.findByLevel(level);
		return !sameLevelMissions.stream()
			.anyMatch(m -> isDuplicatedByOtherMission(pairList, m));
	}

	private boolean isDuplicatedByOtherMission(List<Pair> pairList, Mission otherMission) {
		List<Pair> otherPairList = PairRepository.findByMission(otherMission);
		return otherPairList.stream().anyMatch(p -> isDuplicatedByOtherPair(pairList, p));
	}

	private boolean isDuplicatedByOtherPair(List<Pair> pairList, Pair otherPair) {
		return pairList.stream().anyMatch(p -> p.isDuplicatedPair(otherPair));
	}

	private Pair createPair(Mission mission, List<Crew> shuffledCrew, int index) {
		Crew crew1 = shuffledCrew.get(index);
		Crew crew2 = shuffledCrew.get(index + 1);
		Pair pair = Pair.of(mission, crew1, crew2);

		if (shuffledCrew.size() - index == 3) {
			pair.addCrew(shuffledCrew.get(index + 2));
		}

		return pair;
	}
}
