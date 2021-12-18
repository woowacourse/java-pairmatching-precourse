package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class UserView {
	public String selectOptionToDo() {
		String selection = Console.readLine();
		return selection;
	}

	public String selectCourseLevelMission() {
		System.out.println("과정, 레벨, 미션을 선택하세요.");
		System.out.println("ex) 백엔드, 레벨, 자동차경주");
		String selection = Console.readLine();
		return selection;
	}
}
