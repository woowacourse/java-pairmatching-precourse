package pairmatching.domain.crew;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.pair.Pair;

public class Crews {
	private static final int MAX_CREWS = 3;

	List<String> crewNames;
	List<String> shuffledCrews;

	public Crews(String fileName) {
		crewNames = new ArrayList<>();
		readCrewFile(fileName);
	}

	public void readCrewFile(String fileName) {
		String line;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)))) {
			while ((line = br.readLine()) != null) {
				crewNames.add(line);
			}
		} catch (IOException ignored) {
		}
	}

	public void shuffle() {
		shuffledCrews = Randoms.shuffle(crewNames);
	}

	public List<Pair> makePairs() {
		int index = 0;
		List<Pair> pairs = new ArrayList<>();
		while (index < shuffledCrews.size()) {
			List<String> pairCrews = new ArrayList<>();
			pairCrews.add(shuffledCrews.get(index));
			pairCrews.add(shuffledCrews.get(index + 1));
			if (index == crewNames.size() - 3) {
				pairCrews.add(shuffledCrews.get(index + 2));
				pairs.add(new Pair(pairCrews));
				return pairs;
			}
			pairs.add(new Pair(pairCrews));
			index += 2;
		}
		return pairs;
	}
}
