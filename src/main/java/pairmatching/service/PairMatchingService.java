package pairmatching.service;

import java.io.IOException;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.PairInfo;
import pairmatching.repository.CrewRepository;

public class PairMatchingService {

	private CrewRepository crewRepository = new CrewRepository();

	public PairMatchingService() throws IOException {
	}

	public void match(PairInfo pairInfo) {
		List<String> shuffleCrew = Randoms.shuffle(crewRepository.getByCourse(pairInfo.getCourse()));

		for (int i = 0; i < shuffleCrew.size() - 1; i += 2) {
			Crew leftCrew = new Crew(pairInfo.getCourse(), shuffleCrew.get(i));
			Crew rightCrew =  new Crew(pairInfo.getCourse(), shuffleCrew.get(i + 1));

			if (i + 2 == shuffleCrew.size() - 1) {
				pairInfo.addPairList(
					new Pair(leftCrew, rightCrew, new Crew(pairInfo.getCourse(), shuffleCrew.get(i + 2))));
				break;
			}

			pairInfo.addPairList(new Pair(leftCrew, rightCrew));
		}
	}
}
