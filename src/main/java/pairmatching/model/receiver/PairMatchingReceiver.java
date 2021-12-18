package pairmatching.model.receiver;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.validator.PairMatchingValidator;

public class PairMatchingReceiver {

	public static final String INIT_VALUE_OF_FAIR_MATCHING = "init";
	PairMatchingValidator pairMatchingValidator = new PairMatchingValidator();

	public String receive() {
		String input = INIT_VALUE_OF_FAIR_MATCHING;

		boolean rewindSwitch = true;
		while (rewindSwitch) {
			input = Console.readLine();

			rewindSwitch = pairMatchingValidator.validate(input);
		}

		return input;
	}
}
