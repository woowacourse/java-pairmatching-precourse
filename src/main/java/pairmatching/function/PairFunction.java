package pairmatching.function;

import java.util.Arrays;

import pairmatching.view.OutputView;

public enum PairFunction {
	MATCHING("1"){
		@Override
		public void operate() {
			OutputView.printCourseInformation();
		}
	},
	SEARCH("2"){
		@Override
		public void operate() {

		}
	},
	RESET("3"){
		@Override
		public void operate() {

		}
	},
	QUIT("Q"){
		@Override
		public void operate() {

		}
	},;

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
}
