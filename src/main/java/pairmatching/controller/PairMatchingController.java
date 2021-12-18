package pairmatching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.models.Level;
import pairmatching.models.Pair;

import pairmatching.utils.CourseList;
import pairmatching.utils.MissionList;
import pairmatching.utils.NameList;

import pairmatching.view.PairMachiningOutput;

public class PairMatchingController {

	private final NameList nameList;

	private final PairMachiningOutput output;

	private final InputController input;

	private final List<Pair> pairs;

	private List<Pair> initPairs(final List<Pair> pairs) {
		List<String> courses = CourseList.getCourseList();
		courses.forEach(course -> {
			pairs.add(new Pair(Level.LEVEL1.getLevel(), course));
			pairs.add(new Pair(Level.LEVEL2.getLevel(), course));
			pairs.add(new Pair(Level.LEVEL3.getLevel(), course));
			pairs.add(new Pair(Level.LEVEL4.getLevel(), course));
			pairs.add(new Pair(Level.LEVEL5.getLevel(), course));
		});
		return pairs;
	}

	public PairMatchingController(final NameList nameList, final PairMachiningOutput output,
			final List<Pair> pairs, final InputController input) {
		this.nameList = nameList;
		this.output = output;
		this.pairs = initPairs(pairs);
		this.input = input;
	}

	private List<String> makePair(final List<String> names) {
		List<String> pairs = new ArrayList<>();
		for(int i = 0; i < names.size() - 1; i++) {
			final String crow1 = names.get(i);
			final String crow2 = names.get(i + 1);
			if(names.size() % 2 != 0 && i == names.size() - 3) {
				final String crow3 = names.get(i + 2);
				pairs.add(crow1 + " : " + crow2 + " : " + crow3);
				break;
			}
			pairs.add(crow1 + " : " + crow2);
		}
		return pairs;
	}

	private boolean validatePair(final List<String> pairNames, final Pair targetPair) {
		for(String pairName : pairNames) {
			String[] pair = pairName.split(" : ");
			if(targetPair.existPair(pair[0], pair[1])) {
				return false;
			}
		}
		return true;
	}

	private List<Pair> getTargetPair(final String level, final String course) {
		List<Pair> target = pairs.stream()
			.filter(pair -> pair.getLevel().equals(level) && pair.getCourse().equals(course))
			.collect(Collectors.toList());
		return target;
	}

	private void setExPair(final String level, final String course, final List<String> pairNames) {
		pairs.stream()
			.filter(pair -> pair.getLevel().equals(level) && pair.getCourse().equals(course))
			.forEach(pair -> {
				pairNames.forEach(pairName -> {
					String[] name = pairName.split(" : ");
					pair.addPair(name[0], name[2]);
				});
			});
	}

	public void printMachineResult(final String level, final String course) throws IOException {
		List<String> names = nameList.shuffleName(course);
		List<String> pairNames = makePair(names);
		List<Pair> targetPairList = getTargetPair(level, course);
		if(targetPairList.isEmpty()) {
			setExPair(level, course, pairNames);
		}

		output.printMatchingResult(pairNames);

	}

	public void startProgram() throws IOException {
		while(true) {
			final String function = input.selectFunction();
			if (function.equals("1")) {
				final String[] courseLevelMission = input
					.selectCourseAndMission(CourseList.getCourseList(), (new MissionList()).initMissionList());
				final String course = courseLevelMission[0];
				final String level = courseLevelMission[1];
				final String mission = courseLevelMission[2];
				printMachineResult(level, course);
			}
			if(function.equals("Q")) {
				break;
			}
		}


	}

}
