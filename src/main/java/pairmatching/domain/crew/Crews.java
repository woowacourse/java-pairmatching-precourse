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

	public Pair makePair() {
		if (shuffledCrews.size() == MAX_CREWS) {
			return new Pair(shuffledCrews);
		}

		List<String> pairCrews = new ArrayList<>();
		pairCrews.add(shuffledCrews.remove(0));
		pairCrews.add(shuffledCrews.remove(0));
		return new Pair(pairCrews);
	}

	public boolean done() {
		return shuffledCrews.size() == 0;
	}
}
