package pairmatching.serivce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.Matching;
import pairmatching.type.File;
import pairmatching.type.Course;

public class PairMatching {
	private static final int PAIR_LIMIT = 2;
	private static int nowTimes = 0;
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
		Queue<String> crewQueue = suffledCrews(pairMatching.get("course"));

		ArrayList<ArrayList<String>> matching = new ArrayList<>();
		ArrayList<String> nowMatching = new ArrayList<>();
		while (crewQueue.size() > 0) {
			nowMatching.add(crewQueue.poll());
			nowMatching.add(crewQueue.poll());
			if (crewQueue.size() == 1) {
				nowMatching.add(crewQueue.poll());
			}
			matching.add(nowMatching);
			nowMatching = new ArrayList<>();
		}
		matchings.add(new Matching(pairMatching.get("course"), pairMatching.get("level"), pairMatching.get("mission"), matching));
	}

	private Queue<String> suffledCrews(String course) {
		List<String> crewNames = getCrews(course);
		List<String> suffledCrews = Randoms.shuffle(crewNames);
		return new LinkedList<>(suffledCrews);
	}

	private List<String> getCrews(String course) {
		if (course.equals(Course.BACKEND.getName())) {
			return backEnd;
		}
		return frontEnd;
	}

	private boolean isDuplicated(ArrayList<String> crews) {
		for (Matching matching : matchings) {
			if (matching.isDuplicatedPair(crews)) {
				return true;
			}
		}
		return false;
	}

	private boolean isAvailableReMatching() {
		return nowTimes == times;
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
