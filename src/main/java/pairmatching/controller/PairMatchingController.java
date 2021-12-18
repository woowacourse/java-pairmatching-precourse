package pairmatching.controller;

import java.util.HashMap;
import java.util.Map;

import pairmatching.domain.CourseRepository;
import pairmatching.domain.MissionRepository;
import pairmatching.view.FunctionSelectView;
import pairmatching.view.PairMatchingInputView;
import pairmatching.view.PairMatchingResultView;
import pairmatching.view.PairMatchingSearchView;
import pairmatching.view.PairResetView;
import pairmatching.view.View;

public class PairMatchingController {
	MissionRepository missionRepository = new MissionRepository();
	CourseRepository courseRepository = new CourseRepository();

	private final Map<ViewMappingKey, View> viewMapper = new HashMap<>();

	public PairMatchingController() {
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
}
