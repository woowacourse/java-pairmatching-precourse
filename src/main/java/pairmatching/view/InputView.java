package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static pairmatching.enums.ErrorMessage.*;

import pairmatching.dto.RequestCourseAndLevelAndMissionDto;
import pairmatching.dto.RequestExecuteFeatureDto;
import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class InputView {
	private static final String COURSE_LEVEL_MISSION_SEPARATOR = ", ";

	private static final String EXECUTE_FEATURE_MESSAGE = "기능을 선택하세요." + System.lineSeparator()
		+ "1. 페어 매칭" + System.lineSeparator()
		+ "2. 페어 조회" + System.lineSeparator()
		+ "3. 페어 초기화" + System.lineSeparator()
		+ "Q. 종료";
	private static final String INPUT_COURSE_LEVEL_MISSION_MESSAGE = "과정, 레벨, 미션을 선택하세요."
		+ System.lineSeparator()
		+ "ex) 백엔드, 레벨1, 자동차경주";
	private static final String ALREADY_HAS_PAIRS_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?"
		+ System.lineSeparator()
		+ "네 | 아니오";
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;
	private static final String YES = "네";
	private static final String NO = "아니오";

	public static RequestExecuteFeatureDto inputExecuteFeature() {
		System.out.println(EXECUTE_FEATURE_MESSAGE);
		RequestExecuteFeatureDto requestExecuteFeatureDto = new RequestExecuteFeatureDto(readLine());
		System.out.println();
		return requestExecuteFeatureDto;
	}

	public static RequestCourseAndLevelAndMissionDto inputCourseAndLevelAndMission() {
		System.out.println(INPUT_COURSE_LEVEL_MISSION_MESSAGE);
		String[] inputs = readLine().split(COURSE_LEVEL_MISSION_SEPARATOR);
		return new RequestCourseAndLevelAndMissionDto(
			Course.getByValue(inputs[COURSE_INDEX]), Level.getByValue(inputs[LEVEL_INDEX]), inputs[MISSION_INDEX]);
	}

	public static boolean inputRematching() {
		System.out.println(ALREADY_HAS_PAIRS_MESSAGE);
		String answer = readLine();
		if (answer.equals(YES)) {
			return false;
		}
		if (answer.equals(NO)) {
			return true;
		}
		throw new IllegalArgumentException(REMATCHING_INPUT_ERROR.get());
	}
}
