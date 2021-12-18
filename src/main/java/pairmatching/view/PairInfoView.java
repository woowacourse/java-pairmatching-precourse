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
}
