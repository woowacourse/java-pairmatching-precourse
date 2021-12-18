package pairmatching.view;

import pairmatching.client.ErrorClient;
import pairmatching.client.InputClient;
import pairmatching.client.OutputClient;

public class ViewManager {

	private final InputClient inputClient;
	private final OutputClient outputClient;
	private final ErrorClient errorClient;

	public ViewManager(InputClient inputClient, OutputClient outputClient, ErrorClient errorClient) {
		this.inputClient = inputClient;
		this.outputClient = outputClient;
		this.errorClient = errorClient;
	}


	public String input(InputView inputView) {
		return inputClient.input(inputView.input());
	}

	public void output(OutputView outputView) {
		outputClient.output(outputView.output());
	}

	public void error(ErrorView errorView) {
		errorClient.error(errorView.error());
	}
}
