package pairmatching.processor;

import camp.nextstep.edu.missionutils.Console;

public class InputProcessor {
	private final OutputProcessor outputProcessor = new OutputProcessor();

	public String readPairInformation() {
		outputProcessor.printPairInterface();
		return readLine();
	}

	private String readLine() {
		return Console.readLine();
	}
}
