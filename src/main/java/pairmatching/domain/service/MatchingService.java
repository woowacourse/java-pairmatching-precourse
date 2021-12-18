package pairmatching.domain.service;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Matching;
import pairmatching.domain.MatchingRepository;
import pairmatching.domain.MissionType;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;

public class MatchingService {
	public static void generateMatching(Course course, Level level, MissionType mission) throws IOException {
		if (course.isValidateBackend()) {
			Pairs pairs = calculateBackendMatching();
			MatchingRepository.addMatching(new Matching(course, level, mission, pairs));
		}

		if (course.isValidateFrontend()) {
			calculateFrontendMatching();
		}
	}

	public static Pairs calculateBackendMatching() throws IOException {
		List<String> names = new ArrayList<>();
		fileReader(names);

		List<String> randomNames = Randoms.shuffle(names);
		if (randomNames.size() % 2 == 0) {
			return generateOddFair(names);
		}
		return generateEvenFair(randomNames);
	}

	private static Pairs calculateFrontendMatching() throws IOException {
		List<String> names = new ArrayList<>();
		fileReader(names);

		List<String> randomNames = Randoms.shuffle(names);
		if (randomNames.size() % 2 == 0) {
			return generateOddFair(names);
		}
		return generateEvenFair(randomNames);
	}

	private static Pairs generateEvenFair(List<String> randomNames) {
		List<Pair> pairs = new ArrayList<>();

		for (int i = 0; i < randomNames.size() - 1; i += 2) {
			List<String> names = new ArrayList<>();
			names.add(randomNames.get(i));
			names.add(randomNames.get(i + 1));

			Pair pair = new Pair(names);
			pairs.add(pair);
			if (i == randomNames.size() - 3 && randomNames.size() % 2 != 0) {
				names.add(randomNames.get(i));
			}
		}

		return new Pairs(pairs);
	}

	private static Pairs generateOddFair(List<String> randomNames) {
		List<Pair> pairs = new ArrayList<>();

		for (int i = 0; i < randomNames.size(); i += 2) {
			List<String> names = new ArrayList<>();
			names.add(randomNames.get(i));
			names.add(randomNames.get(i + 1));

			Pair pair = new Pair(names);
			pairs.add(pair);
		}

		return new Pairs(pairs);
	}

	private static void fileReader(List<String> names) throws IOException {
		Path currentPath = Paths.get("");
		String path = currentPath.toAbsolutePath().toString();
		BufferedReader reader = new BufferedReader(new FileReader(path + "/src/main/resources/backend-crew.md"));
		String str;
		while ((str = reader.readLine()) != null) {
			names.add(str);
		}
		reader.close();
	}
}
