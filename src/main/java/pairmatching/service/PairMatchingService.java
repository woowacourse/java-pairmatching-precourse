package pairmatching.service;

import java.io.IOException;

import pairmatching.domain.Pair;

public class PairMatchingService {

	private Pair pair;

	public PairMatchingService() {
		this.pair = new Pair();
	}

	public boolean selectFunction(String input) {
		//TODO: validation

		if(input.equals("Q")) {
			return false;
		}
		pair.initNumber(Integer.parseInt(input));

		return true;
	}

	public boolean selectProcessLevelMission(String input) throws IOException {
		//TODO: validation

		return pair.takeInformation(
			input.replaceAll(" ","").split(","));
	}
}
