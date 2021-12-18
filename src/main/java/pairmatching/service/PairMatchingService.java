package pairmatching.service;

import java.io.IOException;

import pairmatching.domain.Pair;

public class PairMatchingService {

	private Pair pair;

	public boolean selectFunction(String input) {
		//TODO: validation

		if(input.equals("Q")) {
			return false;
		}
		pair = new Pair(Integer.parseInt(input));

		return true;
	}

	public void selectProcessLevelMission(String input) throws IOException {
		//TODO: validation

		pair.shuffleCrew(
			input.replaceAll(" ","").split(","));
	}
}
