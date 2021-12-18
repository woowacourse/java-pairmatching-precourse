package pairmatching.serivce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.Matching;
import pairmatching.type.File;
import pairmatching.type.Course;

public class PairMatching {
	private static final int PAIR_LIMIT = 2;
	private static final int times = 3;

	private List<String> backEnd;
	private List<String> frontEnd;
	private ArrayList<Matching> matchings = new ArrayList<>();

	public void setCrews() {
		backEnd = getFileCrews(File.BACK_END.getName());
		frontEnd = getFileCrews(File.FRONT_END.getName());
	}

	private List<String> getFileCrews(String fileName) {
		return pairmatching.file.File.readFile(fileName);
	}

	public boolean isExistMatch(HashMap<String, String> pairMatching) {
		for (Matching matching : matchings) {
			if (matching.isSameMatching(pairMatching.get("course"), pairMatching.get("level"), pairMatching.get("mission"))) {
				return true;
			}
		}
		return false;
	}

	public void match(HashMap<String, String> pairMatching) {
		int count = 0;
		List<String> suffledCrews = suffledCrews(pairMatching.get("course"));

		ArrayList<ArrayList<String>> matching = new ArrayList<>();
		ArrayList<String> nowMatching = new ArrayList<>();
		for (int i = 0; i < suffledCrews.size(); i += PAIR_LIMIT) {
			nowMatching.add(suffledCrews.get(i));
			nowMatching.add(suffledCrews.get(i + 1));
			matching.add(nowMatching);
			// TODO: 홀수일 경우 마지막 학생 추가
			nowMatching = new ArrayList<>();
		}
		matchings.add(new Matching(pairMatching.get("course"), pairMatching.get("level"), pairMatching.get("mission"), matching));
	}

	private List<String> suffledCrews(String course) {
		List<String> crewNames = getCrews(course);
		return Randoms.shuffle(crewNames);
	}

	private List<String> getCrews(String course) {
		if (course.equals(Course.BACKEND.getName())) {
			return backEnd;
		}
		return frontEnd;
	}

	public void show(HashMap<String, String> pairMatchingMap) {
		Matching selectedMatching;
		for (Matching matching : matchings) {
			if (isExistMatch(pairMatchingMap)) {
				selectedMatching = matching;
				selectedMatching.showCrews();
				break;
			}
		}
	}

	public void reset() {
		matchings = new ArrayList<>();
	}
}
