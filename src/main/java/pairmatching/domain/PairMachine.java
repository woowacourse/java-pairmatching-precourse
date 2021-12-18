package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.utils.FileManager;
import pairmatching.utils.Util;

public class PairMachine {
	private static final PairMachine pairMachine = new PairMachine();
	public static final String SRC_MAIN_RESOURCES_BACKEND_CREW_MD = "./src/main/resources/backend-crew.md";
	public static final String SRC_MAIN_RESOURCES_FRONTEND_CREW_MD = "./src/main/resources/frontend-crew.md";
	private List<Crew> backendCrews;
	private List<Crew> frontendCrews;

	private List<SelectedHistory> history;
	private SelectedHistory currentHistory;

	private PairMachine() {
	}

	public void init() {
		this.backendCrews = FileManager.loadCrewFromFile(SRC_MAIN_RESOURCES_BACKEND_CREW_MD);
		this.frontendCrews = FileManager.loadCrewFromFile(SRC_MAIN_RESOURCES_FRONTEND_CREW_MD);
		history = new ArrayList<>();
	}

	public static PairMachine getInstance() {
		return pairMachine;
	}

	public boolean insertMatchingInfoAndResult(List<String> matchingInfo) {
		SelectedHistory currentHistory = SelectedHistory.from(matchingInfo);
		if (history.contains(currentHistory)) {
			return true;
		}
		this.currentHistory = currentHistory;
		this.history.add(currentHistory);

		return false;
	}

	public String match() {
		List<String> shuffledCrewNames = getShuffledCrewNames();
		List<ArrayList<String>> arrayLists = generatePairedCrewNames(shuffledCrewNames);
		String matchingResult = arrayLists.stream()
			.map(list -> list.stream().collect(Collectors.joining(" : ")))
			.collect(Collectors.joining(System.lineSeparator()));
		this.currentHistory.addResult(matchingResult);

		return matchingResult;

	}

	private List<String> getShuffledCrewNames() {
		List<String> crews = null;

		if (Course.findByName(this.currentHistory.course()) == Course.BACKEND) {
			crews = this.backendCrews.stream()
				.map(crew -> crew.toString())
				.collect(Collectors.toList());
		}
		if (Course.findByName(this.currentHistory.course()) == Course.FRONTEND) {
			crews = this.frontendCrews.stream()
				.map(crew -> crew.toString())
				.collect(Collectors.toList());
		}

		System.out.println(crews);
		return Util.shuffleCrew(crews);
	}

	private static List<ArrayList<String>> generatePairedCrewNames(List<String> crews) {

		List<ArrayList<String>> pairedCrews = new ArrayList<>();

		int limit = 2;

		for (int id = 0; id < crews.size(); id += limit) {
			if (crews.size() % 2 != 0 && id == crews.size() - 3) {
				System.out.println(new ArrayList<>(crews.subList(id, crews.size())));
				pairedCrews.add(new ArrayList<String>(crews.subList(id, crews.size())));
				break;
			}
			pairedCrews.add(new ArrayList<String>(crews.subList(id, Math.min(id + limit, crews.size()))));
		}

		return pairedCrews;
	}

	public String findPair(List<String> matchingInfo) {
		SelectedHistory searchedHistory = this.history.stream()
			.filter(selectedHistory -> selectedHistory.isSame(matchingInfo))
			.findFirst()
			.orElse(null);

		if (searchedHistory != null) {
			return searchedHistory.result();
		}
		return null;
	}
}

