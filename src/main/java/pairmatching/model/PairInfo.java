package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import pairmatching.constant.Message;
import pairmatching.constant.Rule;

public class PairInfo {

	private String course;
	private String level;
	private String mission;

	public PairInfo(String input) {
		checkInput(input);
		input.replaceAll(Message.SPACE, Message.EMPTY);
		List<String> infoList = Arrays.asList(input.split(Rule.DELIMITER_PAIR_INFO));
		course = Course.checkInput(infoList.get(0));
		level = Level.checkInput(infoList.get(1));
		mission = Mission.checkInput(infoList.get(2));
	}

	private void checkInput(String input) {

	}

	public String getCourse() {
		return course;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}

		if (!(other instanceof PairInfo)) {
			return false;
		}

		PairInfo otherPairInfo = (PairInfo)other;
		return course.equals(otherPairInfo.course) && level.equals(otherPairInfo.level) && mission.equals(
			otherPairInfo.mission);
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, mission);
	}
}
