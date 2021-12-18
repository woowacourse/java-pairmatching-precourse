package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Message;
import pairmatching.model.PairInfo;

public class PairInfoView {

	public PairInfo getInput() {
		System.out.println(Message.INPUT_PAIR_INFO);
		try {
			String input = Console.readLine();
			System.out.println();
			return new PairInfo(input);
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR + e.getMessage() + "\n");
			return getInput();
		}
	}

	public void printDuplicationNotice() {
		System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
		System.out.println("네 | 아니오");
	}
}
