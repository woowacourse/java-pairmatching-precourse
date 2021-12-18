package pairmatching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.models.Course;
import pairmatching.utils.NameList;
import pairmatching.utils.PairMatchingMessage;
import pairmatching.view.PairMachiningOutput;

public class PairMatchingController {

	private final NameList nameList;

	private final PairMachiningOutput output;

	public PairMatchingController(final NameList nameList, final PairMachiningOutput output) {
		this.nameList = nameList;
		this.output = output;
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

	public void printMachineResult() throws IOException {
		List<String> names = nameList.shuffleName(Course.FRONTEND.getName());
		output.printMatchingResult(makePair(names));
	}


}
