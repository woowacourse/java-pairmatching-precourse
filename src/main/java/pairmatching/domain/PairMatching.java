package pairmatching.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class PairMatching {

	private static final String ERROR_MESSAGE_INVALID_INPUT_TYPE = "입력 형식이 잘못되었습니다.";
	private static final String ERROR_MESSAGE_NO_MISSION = "해당 미션이 없습니다.";
	private static final String PATTERN = "(프론트엔드|백엔드), (레벨)[1-5](, [가-힣]+)?";
	private static final String COMMA = ",";

	private Course course;
	private Level level;
	private String mission;

	public PairMatching(String inputInformation) {
		validateInputInformation(inputInformation);
		String[] information = inputInformation.split(COMMA);
		this.course = Course.from(information[0].trim());
		this.level = Level.from(information[1].trim());
		if (!level.equals(Level.LEVEL3.getName()) && !level.equals(Level.LEVEL5.getName())) {
			this.mission = information[2].trim();
		}
	}

	private void validateInputInformation(String inputInformation) {
		if (!isValidInputType(inputInformation)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_INPUT_TYPE);
		}
		if (!hasMission(inputInformation)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NO_MISSION);
		}
	}

	private boolean hasMission(String inputInformation) {
		String[] information = inputInformation.split(COMMA);
		String level = information[1].trim();
		if (level.equals(Level.LEVEL3.getName()) || level.equals(Level.LEVEL5.getName())) {
			return true;
		}
		return isContainMission(level, information[2].trim());
	}

	private boolean isContainMission(String level, String mission) {
		return Level.isContainMission(level, mission);
	}

	private boolean isValidInputType(String inputInformation) {
		return Pattern.matches(PATTERN, inputInformation);
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public String getMission() {
		return mission;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PairMatching that = (PairMatching)o;
		return course == that.course && level == that.level && Objects.equals(mission, that.mission);
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, mission);
	}
}
