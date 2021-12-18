package pairmatching.service;

import pairmatching.model.Course;

public class InitializingService {
	public void initialize() {
		Course.BACKEND.getLevelList().forEach(level -> {
			level.getMissions().initialize();
		});
	}
}
