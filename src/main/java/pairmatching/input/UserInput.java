package pairmatching.input;

import pairmatching.model.Function;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

	public Function getFunction() {
		String inputKey = readLine();
		return Function.getFunctionByKey(inputKey);
	}
}
