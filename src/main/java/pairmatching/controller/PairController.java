package pairmatching.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.course.Course;
import pairmatching.domain.level.Level;
import pairmatching.repository.MissionRepository;
import pairmatching.view.OutputView;

public class PairController {
	private static final String LEVEL_MISSIONS_FORMAT = "%s: %s";

	public void startMatching() {
		showOverview();
	}

	private void showOverview() {
		List<String> levelMissions = Arrays.stream(Level.values())
			.map(level -> String.format(LEVEL_MISSIONS_FORMAT, level.getName(), MissionRepository.findMissions(level)))
			.collect(Collectors.toList());
		List<String> courses = Arrays.stream(Course.values())
			.map(Course::getName)
			.collect(Collectors.toList());

		OutputView.printOverview(courses, levelMissions);
	}

	public void startView() {
		System.out.println("조회 메뉴 진입");
	}

	public void startClear() {
		System.out.println("초기화 메뉴 진입");
	}
}
