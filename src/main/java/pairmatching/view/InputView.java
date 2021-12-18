package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.common.MainCategory;

public class InputView {
	private static final String ERROR = "[ERROR] ";
	private static final String ERROR_INVALID_OPTION = ERROR + "존재하지 않는 명령입니다.";

	public String selectMainCategory(List<MainCategory> mainCategoryList) {
		List<String> mainCategoryMethods = mainCategoryList.stream()
			.map(MainCategory::getCategory)
			.collect(Collectors.toList());
		String option = Console.readLine();
		if (!mainCategoryMethods.contains(option)) {
			throw new IllegalArgumentException(ERROR_INVALID_OPTION);
		}
		return option;
	}
}