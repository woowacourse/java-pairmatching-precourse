package pairmatching.view;

public class ViewManager {

	private final InputView inputView;
	private final OutputView outputView;
	private final ErrorView errorView;

	public ViewManager(InputView inputView, OutputView outputView, ErrorView errorView) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.errorView = errorView;
	}

	public String input() {
		return inputView.input();
	}

	public void error(String message) {
		errorView.error(message);
	}

	public void output(String message) {
		outputView.output(message);
	}
}
