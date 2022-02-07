package pairmatching.utils.validator;

import java.util.Arrays;
import java.util.Objects;

import pairmatching.domain.Level;
import pairmatching.domain.repository.Repository;
import pairmatching.utils.Constants;
import pairmatching.utils.Converter;

public class MissionValidator {
	private final String input;
	private String[] missionInfo;
	private Level level;

	public MissionValidator(String input) {
		this.input = input;
		validate();
	}

	private void validate() {
		isRightString();
		missionInfo = input.split(", ");
		isRightBranch();
		isRightLevel();
		isRightMission();
	}

	private void isRightMission() {
		if (Arrays.stream(level.missionNames).noneMatch(s -> Objects.equals(s, missionInfo[2]))) {
			throw new IllegalArgumentException("잘못된 입력이다.");
		}
	}

	private void isRightString() {
		if (!Constants.MISSION_PATTERN.matcher(input).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_MISSION_PATTERN);
		}
	}

	private void isRightBranch() {
		if (!missionInfo[0].equals("백엔드") && !missionInfo[0].equals("프론트엔드")) {
			throw new IllegalArgumentException(Constants.ERROR_MISSION_PATTERN);
		}
	}

	private void isRightLevel() {
		Repository.levelFind(missionInfo[1]);
		level = Repository.levels.get(
			Converter.getInt(
				Character.toString(missionInfo[1].charAt(2))
			) - 1
		);
	}
}
