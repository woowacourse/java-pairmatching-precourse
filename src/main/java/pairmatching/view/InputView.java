package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.common.MainCategory;
import pairmatching.common.RematchOption;

public class InputView {
	private static final String DELIMITER_COMMA = ",";
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

	public List<String> scanPairCondition() {

		List<String> s =  Splitter.on(DELIMITER_COMMA).trimResults().omitEmptyStrings().splitToList(Console.readLine());
		return s;
	}

	public String selectRematchOption(List<RematchOption> rematchOptionList) {
		List<String> rematchOptionMethods = rematchOptionList.stream()
			.map(RematchOption::getOption)
			.collect(Collectors.toList());
		String option = Console.readLine();
		if (!rematchOptionMethods.contains(option)) {
			throw new IllegalArgumentException(ERROR_INVALID_OPTION);
		}
		return option;
	}
}