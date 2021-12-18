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
		// TODO 구현 진행
		Application app = AppConfig.getApplication();
		app.run();
	}

	private void run() {
		while (true) {
			String input = viewManager.input(new ApplicationInputView());
			ControllerType controllerType;
			try {
				controllerType = ControllerType.of(input);
				execute(controllerType);
			} catch (IllegalArgumentException e) {
				viewManager.error(new CommonErrorView(e.getMessage()));
				continue;
			}
			if (ControllerType.QUIT.equals(controllerType)) {
				break;
			}
		}
	}

	private void execute(ControllerType controllerType) {
		controllerType.controlAction();
	}
}
