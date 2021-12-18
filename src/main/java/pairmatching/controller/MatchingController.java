package pairmatching.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Menu;
import pairmatching.domain.Pair;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.CrewRepository;
import pairmatching.domain.matcing.Matching;
import pairmatching.domain.matcing.MatchingRepository;
import pairmatching.view.OutputView;

public class MatchingController {

	private final MatchingRepository matchingRepository;
	private final CrewRepository crewRepository;

	public MatchingController(MatchingRepository matchingRepository) {
		this.matchingRepository = matchingRepository;
		this.crewRepository = new CrewRepository();
	}

	public void matching(Menu menu) {
		List<String> crewNames = createCrewNames(menu.getCourse());
		List<String> shuffledCrew = Randoms.shuffle(crewNames);

		List<Crew> list = crewRepository.getCrews(menu.getLevel());
		if (list.size() != 0) { // 매칭 이력이 존재한다.
			// 다시 셔플
		}

		Matching matching = createMatching(menu, shuffledCrew);

		OutputView.printMatching(matching.getPairs());
		matchingRepository.addMatching(matching);
	}

	private Matching createMatching(Menu menu, List<String> shuffledCrew) {
		Matching matching = new Matching(menu.getCourse(), menu.getLevel(), menu.getMission());
		Queue<String> queue = new LinkedList<>(shuffledCrew);
		while (!queue.isEmpty()) {
			Pair pair = new Pair(queue.poll(), queue.poll());
			if (queue.size() == 1) {
				pair.addName(queue.poll());
			}
			matching.addPair(pair);
		}

		return matching;
	}

	private List<String> createCrewNames(Course course) {
		ArrayList<String> crewNames = new ArrayList<>();
		String filePath = "src/main/resources/" + course.name().toLowerCase() + "-crew.md";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String crewName;
			while ((crewName = reader.readLine()) != null) {
				crewNames.add(crewName);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return crewNames;
	}

	public void init() {
		matchingRepository.init();
		crewRepository.init();
	}
}
