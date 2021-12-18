package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Application;
import pairmatching.util.SystemMessage;

public class PairMatchingInputView implements View {
	@Override
	public void flow() {
		String missionInfo = readMissionInfo();
	}

	@Override
	public void printViewMessage() {
		System.out.println(SystemMessage.INFO_LINE);
		String courseListString = Application.controller.getCourseListString();
		System.out.println(SystemMessage.COURSE + courseListString);
		System.out.println(SystemMessage.MISSION);
		String missionListString = Application.controller.getMissionListString();
		System.out.println(missionListString);
		System.out.println(SystemMessage.INFO_LINE);
		System.out.println(SystemMessage.INPUT_MISSION_INFO);
		System.out.println(SystemMessage.MISSION_INFO_EX);
	}

	private String readMissionInfo() {
		return Console.readLine();
	}
}
