package pairmatching.application;

import static java.util.stream.Collectors.toList;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.CrewRepository;
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
		List<Pair> result = new ArrayList<>();
		List<Crew> shuffledCrew = getShuffledCrewByCourse(mission.getCourse());

		for (int index = 0; index < shuffledCrew.size(); index += 2) {
			result.add(createPair(mission, shuffledCrew, index));
			if (isThreeCrewsInLastPair(shuffledCrew, index)) {
				break;
			}
		}

		return result;
	}

	private boolean isThreeCrewsInLastPair(List<Crew> shuffledCrew, int index) {
		return shuffledCrew.size() - index == 3;
	}

	private List<Crew> getShuffledCrewByCourse(Course course) {
		return getShuffledCrewNamesByCourse(course).stream().map(CrewRepository::findByName).collect(toList());
	}

	private List<String> getShuffledCrewNamesByCourse(Course course) {
		return Randoms.shuffle(CrewRepository.findAllByCourse(course).stream().map(Crew::getName).collect(toList()));
	}

	private boolean isThreeCrewsInLastPair(List<Crew> shuffledCrew, int index) {
		return shuffledCrew.size() - index == 3;
	}

	private boolean isValidPairList(Mission mission, List<Pair> pairList) {
		List<Mission> sameLevelMissions = MissionRepository.findByLevelAndCourse(mission.getLevel(), mission.getCourse());
		return !sameLevelMissions.stream()
			.anyMatch(m -> isDuplicatedPairByOtherMission(pairList, m));
	}

	private boolean isDuplicatedPairByOtherMission(List<Pair> pairList, Mission otherMission) {
		List<Pair> otherPairList = PairRepository.findByCourseAndMission(otherMission);
		return otherPairList.stream().anyMatch(p -> isDuplicatedByOtherPairList(pairList, p));
	}

	private boolean isDuplicatedByOtherPairList(List<Pair> pairList, Pair otherPair) {
		return pairList.stream().anyMatch(p -> p.isDuplicatedPair(otherPair));
	}

	private Pair createPair(Mission mission, List<Crew> shuffledCrew, int index) {
		Crew crew1 = shuffledCrew.get(index);
		Crew crew2 = shuffledCrew.get(index + 1);
		Pair pair = Pair.of(mission, crew1, crew2);

		if (isThreeCrewsInLastPair(shuffledCrew, index)) {
			pair.addCrew(shuffledCrew.get(index + 2));
		}

		return pair;
	}
}
