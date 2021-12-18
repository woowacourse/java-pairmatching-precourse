package pairmatching.serivce;

import java.util.ArrayList;
import java.util.HashMap;
import pairmatching.model.Matching;
import pairmatching.repository.BackEndRepository;
import pairmatching.repository.FrontEndRepository;
import pairmatching.type.File;

public class PairMatching {
	private BackEndRepository backEnd;
	private FrontEndRepository frontEnd;
	private ArrayList<Matching> matchings = new ArrayList<>();
	private int times = 3;

	public void setCrews() {
		backEnd = getBackEnd();
		frontEnd = getFrontEnd();
	}

	private BackEndRepository getBackEnd() {
		String fileName = File.BACK_END.getName();
		ArrayList<String> crewNames = pairmatching.file.File.readFile(fileName);

		BackEndRepository backEndRepositories = new BackEndRepository(crewNames);

		return backEndRepositories;
	}

	private FrontEndRepository getFrontEnd() {
		String fileName = File.FRONT_END.getName();
		ArrayList<String> crewNames = pairmatching.file.File.readFile(fileName);

		FrontEndRepository frontEndRepositories = new FrontEndRepository(crewNames);

		return frontEndRepositories;
	}

	public boolean isAvailableMatch(HashMap<String, String> pairMatching) {
		for (Matching matching : matchings) {
			if (!matching.isSameCourse(pairMatching.get("course"))) {
				return true;
			}
			if (!matching.isSameLevel(pairMatching.get("level"))) {
				return true;
			}
			if (!matching.isSameMission(pairMatching.get("mission"))) {
				return true;
			}
		}
		return false;
	}

	public void match(HashMap<String, String> pairMatching) {
		int count = 0;
	}
}
