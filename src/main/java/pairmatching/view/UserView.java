package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class UserView {
	public String selectOptionToDo() {
		String selection = Console.readLine();
		return selection;
	}

	public String selectCourseLevelMission() {
		System.out.println("과정, 레벨, 미션을 선택하세요.");
		System.out.println("ex) 백엔드, 레벨1, 자동차경주");
		String selection = Console.readLine();
		return selection;
	}

	public static boolean reMatch() {
		System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오");
		String reMatchMessage = Console.readLine();

		if (reMatchMessage.equals("아니오")) {
			return false;
		}

		return true;
	}
}
