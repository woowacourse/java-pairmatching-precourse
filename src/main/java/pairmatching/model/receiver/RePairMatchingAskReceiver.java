package pairmatching.model.receiver;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.validator.RePairMatchingAskValidator;

public class RePairMatchingAskReceiver {

	public static final String INIT_VALUE_OF_RE_PAIR_MATCHING_ASK_INPUT = "init";

	RePairMatchingAskValidator rePairMatchingAskValidator = new RePairMatchingAskValidator();

	public String receive() {
		String input = INIT_VALUE_OF_RE_PAIR_MATCHING_ASK_INPUT;

		boolean rewindSwitch = true;
		while (rewindSwitch) {
			input = Console.readLine();

			rewindSwitch = rePairMatchingAskValidator.validate(input);
		}

		return input;
	}
}
