package pairmatching.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pairmatching.constant.Course;
import pairmatching.domain.PairMatching;

public class PairMatchingController {
	private PairMatching pairMatching;

	public PairMatchingController() {
		pairMatching = new PairMatching();
	}

	public void ready() {
		pairMatching.setCrews(Course.BACKEND, readBackEndCrewFile());
		System.out.println(pairMatching.getCrewNames(Course.BACKEND));
		pairMatching.setCrews(Course.FRONTEND, readFrontEndCrewFile());
		System.out.println(pairMatching.getCrewNames(Course.FRONTEND));
	}

	private List<String> readBackEndCrewFile() {
		List<String> crewNames = new ArrayList<>();
		try {
			Path path = Paths.get("D:\\woowacourse\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md");
			Stream<String> lines = Files.lines(path);
			crewNames = lines.collect(Collectors.toList());
			lines.close();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일을 읽는데 실패하였습니다.");
		}
		return crewNames;
	}

	private List<String> readFrontEndCrewFile() {
		List<String> crewNames = new ArrayList<>();
		try {
			Path path = Paths.get("D:\\woowacourse\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md");
			Stream<String> lines = Files.lines(path);
			crewNames = lines.collect(Collectors.toList());
			lines.close();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일을 읽는데 실패하였습니다.");
		}
		return crewNames;
	}
}
