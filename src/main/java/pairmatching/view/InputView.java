package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.*;

import pairmatching.dto.RequestExecuteFeatureDto;

public class InputView {
	private static final String EXECUTE_FEATURE_MESSAGE = "기능을 선택하세요." + System.lineSeparator()
		+ "1. 페어 매칭" + System.lineSeparator()
		+ "2. 페어 조회" + System.lineSeparator()
		+ "3. 페어 초기화" + System.lineSeparator()
		+ "Q. 종료";

	public static RequestExecuteFeatureDto inputExecuteFeature() {
		System.out.println(EXECUTE_FEATURE_MESSAGE);
		RequestExecuteFeatureDto requestExecuteFeatureDto = new RequestExecuteFeatureDto(readLine());
		System.out.println();
		return requestExecuteFeatureDto;
	}
}
