package pairmatching;

import pairmatching.config.AppConfig;
import pairmatching.controller.ControllerType;
import pairmatching.view.ViewManager;
import pairmatching.view.app.ApplicationInputView;
import pairmatching.view.common.CommonErrorView;

public class Application {

	private final ViewManager viewManager;

	public Application(ViewManager viewManager) {
		this.viewManager = viewManager;
	}

	public static void main(String[] args) {
		Application app = AppConfig.getApplication();
		app.run();
	}

	private void run() {
		String input = viewManager.input(new ApplicationInputView());
		try {
			ControllerType controllerType = ControllerType.of(input);
			if (ControllerType.QUIT.equals(controllerType)) {
				return;
			}
			execute(controllerType);
		} catch (IllegalArgumentException e) {
			viewManager.error(new CommonErrorView(e.getMessage()));
		}
		run();
	}

	private void execute(ControllerType controllerType) {
		controllerType.controlAction();
	}
}
