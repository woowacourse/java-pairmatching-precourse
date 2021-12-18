package pairmatching.controller;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.List;

import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.CrewPair;
import pairmatching.model.NamePair;
import pairmatching.model.ProgramData;

public class PairMaker {
	public PairMaker() {

	}

	public List<NamePair> make(ProgramData data, String course, String level, String mission) {
		List<String> tmp = new ArrayList<>();
		List<Crew> tmpCrew = data.getBackendCrews();
		if (course.equals("프론트엔드")) {
			tmpCrew = data.getFrontendCrews();
		}
		for (Crew crew : tmpCrew) {
			tmp.add(crew.getName());
		}
		List<NamePair> result = new ArrayList<>();
		tmp = shuffle(tmp);
		if (tmp.size() % 2 == 0) {
			for (int i = 0; i < tmp.size(); i += 2) {
				if (data.getHistory().containsKey(level)) {
					if (data.getHistory().get(level).contains(new NamePair(tmp.get(i), tmp.get(i + 1)))) {
						List<NamePair> exist = new ArrayList<>();
						exist.add(new NamePair("exist", "exist"));
						return exist;
					}
					result.add(new NamePair(tmp.get(i), tmp.get(i + 1)));
				}
				if (!data.getHistory().containsKey(level)) {
					result.add(new NamePair(tmp.get(i), tmp.get(i + 1)));
				}
			}
			return result;
		}
		for (int i = 0; i < tmp.size() - 1; i += 2) {
			if (data.getHistory().containsKey(level)) {
				if (data.getHistory().get(level).contains(new NamePair(tmp.get(i), tmp.get(i + 1)))) {
					List<NamePair> exist = new ArrayList<>();
					exist.add(new NamePair("exist", "exist"));
					return exist;
				}
				result.add(new NamePair(tmp.get(i), tmp.get(i + 1)));
			}
			if (!data.getHistory().containsKey(level)) {
				result.add(new NamePair(tmp.get(i), tmp.get(i + 1)));
			}

			return result;
		}
		return result;
	}
}
