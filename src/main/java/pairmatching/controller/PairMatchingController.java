package pairmatching.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.Course;
import pairmatching.domain.CourseRepository;
import pairmatching.domain.CrewRepository;
import pairmatching.domain.Level;
import pairmatching.domain.MatchParams;
import pairmatching.domain.Mission;
import pairmatching.domain.MissionRepository;
import pairmatching.domain.PairRepository;
import pairmatching.view.FunctionSelectView;
import pairmatching.view.PairMatchingInputView;
import pairmatching.view.PairMatchingResultView;
import pairmatching.view.PairMatchingSearchView;
import pairmatching.view.PairResetView;
import pairmatching.view.View;

public class PairMatchingController {
	MissionRepository missionRepository = new MissionRepository();
	CourseRepository courseRepository = new CourseRepository();
	MatchParams matchParams = null;
	CrewRepository crewRepository = new CrewRepository();
	PairRepository pairRepository = new PairRepository();

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

	public void setParams(List<String> params) {
		matchParams = new MatchParams(Course.valueOf(params.get(0)),
			Level.valueOf(params.get(1)),
			Mission.valueOf(params.get(2)));
	}

	public void pairMatching() {

	}
}
