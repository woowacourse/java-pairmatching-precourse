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

		// 1. 입력한 과정 -> 해당과정의 크루원들만 뽑아서 셔틀하여 반환함.
		List<String> shuffledCrewNames = getShuffledCrewNames();
		// 2. 2명씩 묶기 by generatePairedCrews
		List<ArrayList<String>> arrayLists = generatePairedCrewNames(shuffledCrewNames);
		// 3. 페어결과를 문자열로 반환하기
		String matchingResult = arrayLists.stream()
			.map(list -> list.stream().collect(Collectors.joining(" : ")))
			.collect(Collectors.joining(System.lineSeparator()));
		this.currentHistory.addResult(matchingResult);

		return matchingResult;

	}

	private List<String> getShuffledCrewNames() {
		List<String> crews = null;

		// 1. 입력된 course에 따라 1개만  가져온다.
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
		// System.out.println(crews);
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
			// System.out.println(new ArrayList<>(crews.subList(id, Math.min(id + limit, crews.size()))));
			pairedCrews.add(new ArrayList<String>(crews.subList(id, Math.min(id + limit, crews.size()))));
		}

		// [[백호, 태웅], [치수, 태섭], [대만, 준호], [대협, 덕규], [태산, 경태], [수겸, 현준], [준섭, 한나], [소연, 호열], [대남, 용팔], [구식, 달재]]
		return pairedCrews;
	}

	public String findPair(List<String> matchingInfo) {
		// SelectedHistory selectedHistory = SelectedHistory.from(matchingInfo);
		// 히스토리마다, 매칭결과도 가지도록..( 나중에 채워지게 null로 넣어놓고)
		// if (this.history.contains(selectedHistory)){
		SelectedHistory searchedHistory = this.history.stream()
			.filter(selectedHistory -> selectedHistory.isSame(matchingInfo))
			.findFirst()
			.orElse(null);

		// System.out.println("[로그] 참고용 searchedHistory :" + searchedHistory); // TODO 삭제
		// System.out.println("[로그] 참고용 searchedHistory.result() :" + searchedHistory.result()); // TODO 삭제
		// return searchedHistory.result();

		if (searchedHistory != null) {
			return searchedHistory.result();
		}
		//
		return null;
	}
}

