package pairmatching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.CourseRepository;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewRepository;
import pairmatching.domain.Level;
import pairmatching.domain.MatchParams;
import pairmatching.domain.Mission;
import pairmatching.domain.MissionRepository;
import pairmatching.domain.PairRepository;
import pairmatching.util.SystemMessage;
import pairmatching.view.FunctionSelectView;
import pairmatching.view.PairMatchingInputView;
import pairmatching.view.PairMatchingResultView;
import pairmatching.view.PairMatchingSearchView;
import pairmatching.view.PairResetView;
import pairmatching.view.View;

public class PairMatchingController {
	private static final String PAIR_DELIMITER = " : ";

	MissionRepository missionRepository = new MissionRepository();
	CourseRepository courseRepository = new CourseRepository();
	CrewRepository crewRepository = new CrewRepository();
	PairRepository pairRepository = new PairRepository();
	MatchParams lastMatchParams = null;

	private final Map<ViewMappingKey, View> viewMapper = new HashMap<>();

	public PairMatchingController() throws IOException {
		viewMapper.put(ViewMappingKey.FUNCTION_SELECT, new FunctionSelectView());
		viewMapper.put(ViewMappingKey.PAIR_MATCHING_INPUT, new PairMatchingInputView());
		viewMapper.put(ViewMappingKey.PAIR_MATCHING_RESULT, new PairMatchingResultView());
		viewMapper.put(ViewMappingKey.PAIR_MATCHING_SEARCH, new PairMatchingSearchView());
		viewMapper.put(ViewMappingKey.PAIR_RESET, new PairResetView());
	}

	public void view(ViewMappingKey key) {
		viewMapper.get(key).printViewMessage();
		viewMapper.get(key).flow();
	}

	public String getMissionListString() {
		return missionRepository.getMissionListString();
	}

	public String getCourseListString() {
		return courseRepository.getCourseListString();
	}

	public boolean pairMatching() {
		List<List<String>> pairs = new ArrayList<>();
		List<String> crewNames = crewRepository.getCrews().stream()
			.filter(item -> item.getCourse().equals(lastMatchParams.getCourse()))
			.map(Crew::getName)
			.collect(Collectors.toList());

		shuffleAndPair(pairs, crewNames);
		if (!testPairs(pairs, crewNames))
			return false;

		pairRepository.addPair(lastMatchParams, pairs);
		return true;
	}

	private boolean hasSamePairInThisLevel(List<List<String>> pairs) {
		List<String> pairListByCourseAndLevel = pairRepository.getPairsByCourseAndLevel(lastMatchParams.getCourse(),
			lastMatchParams.getLevel());
		List<String> pairStringList = pairs.stream()
			.map(item -> String.join(PAIR_DELIMITER, item))
			.collect(Collectors.toList());

		for (String pairString : pairStringList) {
			if (pairListByCourseAndLevel.contains(pairString))
				return true;
		}

		return false;
	}

	private boolean testPairs(List<List<String>> pairs, List<String> crewNames) {
		int i;
		for (i = 0; i < 3; i++) {
			if (hasSamePairInThisLevel(pairs)) {
				shuffleAndPair(pairs, crewNames);
				continue;
			}
			break;
		}
		return i != 3;
	}

	private void shuffleAndPair(List<List<String>> pairs, List<String> crewNames) {
		List<String> shuffledCrew = Randoms.shuffle(crewNames);
		for (int i = 0; i < shuffledCrew.size(); i += 2) {
			if (i + 1 >= shuffledCrew.size()) // 한명 남을 경우 종료
				break;
			List<String> pair = new ArrayList<>();
			pair.add(shuffledCrew.get(i));
			pair.add(shuffledCrew.get(i + 1));
			pairs.add(pair);
		}

		if (shuffledCrew.size() % 2 == 1) // 홀수라서 한명 남은 경우 한명을 마지막 페어에 추가
			pairs.get(pairs.size() - 1).add(shuffledCrew.get(shuffledCrew.size() - 1));
	}

	public MatchParams setMatchParams(List<String> params) {
		lastMatchParams = new MatchParams(Course.getInstance(params.get(0)),
			Level.getInstance(params.get(1)),
			Mission.getInstance(params.get(2)));

		return lastMatchParams;
	}

	public String getMatchResult() {
		return pairRepository.getMatchResultString(lastMatchParams);
	}

	public boolean isExistParam(MatchParams params) {
		return pairRepository.isExistParam(params);
	}

	public void resetPairs() {
		pairRepository.resetPairs();
	}
}
