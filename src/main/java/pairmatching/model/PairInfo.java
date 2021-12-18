package pairmatching.model;

import java.util.Arrays;
import java.util.List;

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
}
