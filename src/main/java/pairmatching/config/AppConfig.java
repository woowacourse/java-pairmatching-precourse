package pairmatching.config;

import pairmatching.Application;

public class AppConfig {

	public static Application getApplication() {
		return new Application(ViewManagerConfig.getViewManager());
	}
}
