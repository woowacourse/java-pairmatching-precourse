package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import pairmatching.view.OutputView;

public class Pair {

	private List<List<Crew>> pairs;

	public Pair(List<Crew> crews) {
		pairs = new ArrayList<>();
		for (int i = 0; i < crews.size(); i += 2) {
			List<Crew> newPair = new ArrayList<>();
			newPair.add(crews.get(i));
			newPair.add(crews.get(i + 1));
			pairs.add(newPair);
		}
		if (crews.size() % 2 != 0) {
			int crewIndex = crews.size() - 1;
			Course course = crews.get(crewIndex).getCourse();
			String name = crews.get(crewIndex).getName();
			pairs.get(pairs.size() - 1).add(new Crew(course, name));
		}
	}

	public void findPair() {
		OutputView.printResultFindPair();
		for (List<Crew> pair : pairs) {
			OutputView.printPair(pair);
		}
		OutputView.printNewLine();
	}
}
