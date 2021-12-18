package pairmatching.config;

import pairmatching.view.ViewManager;

public class ViewManagerConfig {
	public static ViewManager getViewManager() {
		return new ViewManager(
			ClientConfig.getInputClient(),
			ClientConfig.getOutputClient(),
			ClientConfig.getErrorClient()
		);
	}
}
