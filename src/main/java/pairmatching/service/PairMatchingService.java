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

	public boolean selectProcessLevelMission(String input) throws IOException {
		//TODO: validation

		return pair.takeInformation(
			input.replaceAll(" ","").split(","));
	}

	public boolean queryReMatching(String input) {
		//TODO: validation

		if(input.equals("아니오")) {
			return false;
		}


		return true;
	}
}
