package pairmatching.client;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputClient implements InputClient {

	private OutputClient outputClient;

	public ConsoleInputClient(OutputClient outputClient) {
		this.outputClient = outputClient;
	}

	@Override
	public String input(String prompt) {
		outputClient.output(prompt);
		return Console.readLine();
	}
}
