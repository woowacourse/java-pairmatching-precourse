package pairmatching.view;

import pairmatching.client.OutputClient;

public abstract class OutputView {
	private final OutputClient outputClient;

	public OutputView(OutputClient outputClient) {
		this.outputClient = outputClient;
	}

	public void output(String msg) {
		String intro = getIntro();
		if (intro != null) {
			outputClient.output(intro);
		}
		outputClient.output(msg);
	}

	protected abstract String getIntro();
}
