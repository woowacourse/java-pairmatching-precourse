package pairmatching.function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.CourseRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public enum PairFunction {
	MATCHING("1") {
		@Override
		public void operate() {
			OutputView.printCourseLevelMissionInformation();
			try {
				List<String> informationList = getCourseLevelMissionInput();
				requestPairMatching(informationList);
			} catch (IllegalArgumentException exception) {
				OutputView.printErrorMessage(exception.getMessage());
			}
		}
	},
	SEARCH("2") {
		@Override
		public void operate() {
			OutputView.printCourseLevelMissionInformation();
			try {
				List<String> informationList = getCourseLevelMissionInput();
				OutputView.printCrewPairResult(informationList);
			} catch (IllegalArgumentException exception) {
				OutputView.printErrorMessage(exception.getMessage());
			}
		}
	},
	RESET("3") {
		@Override
		public void operate() {
			CourseRepository.ResetPair();
			System.out.println("\n초기화 되었습니다.\n");
		}
	},
	QUIT("Q") {
		@Override
		public void operate() {
		}
	};

	private String menu;

	PairFunction(String menu) {
		this.menu = menu;
	}

	public static PairFunction getPairFunctionByMenu(String menu) {
		return Arrays.stream(PairFunction.values())
			.filter(pairFunction -> pairFunction.menu.equals(menu))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."));
	}

	public abstract void operate();

	private static List<String> getCourseLevelMissionInput() {
		String informationInput = InputView.getCourseLevelMissionInformation();
		List<String> informationList = Arrays.stream(informationInput.split(",")).collect(Collectors.toList());
		return informationList.stream()
			.map(String::trim)
			.collect(Collectors.toList());
	}

	private static void requestPairMatching(List<String> informationList) {
		if (CourseRepository.isExistPairMatching(informationList.get(0), informationList.get(1), informationList.get(2))) {
			String newMatchingOpinion = InputView.getNewMatchingInput();
			if (newMatchingOpinion.equals("아니오")) {
				return;
			}
		}
		CourseRepository.makePair(informationList.get(0), informationList.get(1), informationList.get(2));
		List<String> crewPairs = CourseRepository.getMatchingList(informationList.get(0), informationList.get(1), informationList.get(2));
		OutputView.printCrewPairResult(crewPairs);
	}
}
