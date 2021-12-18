package pairmatching.view;

import pairmatching.client.InputClient;

public abstract class InputView {
	private final InputClient inputClient;

	public InputView(InputClient inputClient) {
		this.inputClient = inputClient;
	}

	public String input() {
		return inputClient.input(getPrompt());
	}

	protected abstract String getPrompt();
}
