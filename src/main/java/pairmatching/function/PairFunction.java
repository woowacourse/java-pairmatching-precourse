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
			List<String> informationList = getCourseLevelMissionInput();
			if (CourseRepository.isExistPairMatching(informationList.get(0), informationList.get(1), informationList.get(2))) {

			}
		}
	},
	SEARCH("2") {
		@Override
		public void operate() {

		}
	},
	RESET("3") {
		@Override
		public void operate() {

		}
	},
	QUIT("Q") {
		@Override
		public void operate() {

		}
	},
	;

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
		informationList.forEach(String::trim);
		return informationList;
	}
}
