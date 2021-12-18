package pairmatching.model;

import static pairmatching.constants.Constants.*;
import static pairmatching.constants.ErrorMessage.*;

import java.util.LinkedList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.util.FileUtils;

public class PairMatching {
	private MatchingHistory matchingHistory;
	private MatchingInfo matchingInfo;
	private List<Crew> crews;

	public PairMatching() {
		matchingHistory = new MatchingHistory();
		matchingInfo = new MatchingInfo();
		setCrews();
	}

	private void setCrews() {
		crews = new LinkedList<>();
		List<String> backendCrew = FileUtils.readFile(BACKEND_CREW_FILE);
		backendCrew.forEach(name -> crews.add(new Crew(Course.BACKEND, name)));

		List<String> frontendCrew = FileUtils.readFile(FRONTEND_CREW_FILE);
		frontendCrew.forEach(name -> crews.add(new Crew(Course.FRONTEND, name)));
	}

	public void matchingPair(String[] courseInfos) {
		crews = Randoms.shuffle(crews);
		int resetCnt = RESET_START;
		while (true) {
			List<Pair> pairList = makePairs(Level.findLevelByString(courseInfos[LEVEL_IDX]), courseInfos[COURSE_IDX]);
			matchingHistory.addHisotry(Level.findLevelByString(courseInfos[LEVEL_IDX]), pairList);
			matchingInfo.addInfo(courseInfos, pairList);
			if (pairList == null) {
				resetCnt++;
			}
			if (resetCnt == RESET_CNT) {
				throw new IllegalArgumentException(PAIR_EXIST);
			}
		}
	}

	public List<Pair> makePairs(Level level, String course) {
		List<Pair> pairList = new LinkedList<>();
		List<String> pair = new LinkedList<>();
		for (Crew crew:
			crews) {
			if (!crew.sameCourse(course)) {
				continue;
			}
			if (pair.size() == PAIR_CNT) {
				pairList.add(new Pair(pair));
				pair = new LinkedList<>();
			}
			pair.add(crew.getName());
			if (matchingHistory.isExistPair(level, pair)) {
				return null;
			}
		}
		return pairList;
	}

}
