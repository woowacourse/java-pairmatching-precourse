package pairmatching.config;

import pairmatching.repository.WoowaCourseRepository;

public class RepositoryConfig {
	public static WoowaCourseRepository getWoowaCourseRepository() {
		return new WoowaCourseRepository();
	}
}
