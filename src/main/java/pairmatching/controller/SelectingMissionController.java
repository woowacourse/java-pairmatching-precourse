package pairmatching.controller;

import pairmatching.inputview.InputView;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.outputview.OutputView;
import pairmatching.repository.MissionRepository;

import java.util.Map;

public class SelectingMissionController implements Controller {
    private final OutputView outputView;
    private final InputView inputView;
    private final MissionRepository missionRepository;

    public SelectingMissionController(OutputView outputView, InputView inputView, MissionRepository missionRepository) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.missionRepository = missionRepository;
    }

    @Override
    public void process(Map<String, Object> model) {
        putCoursesNameToModel(model);
        putMissionNamesToModel(model);
        outputView.print(model);
    }

    private static Object putCoursesNameToModel(Map<String, Object> model) {
        return model.put("courses", Course.getCourseNames());
    }

    private void putMissionNamesToModel(Map<String, Object> model) {
        model.put("level1Missions", missionRepository.findAllNamesByLevel(Level.LEVEL1));
        model.put("level2Missions", missionRepository.findAllNamesByLevel(Level.LEVEL2));
        model.put("level3Missions", missionRepository.findAllNamesByLevel(Level.LEVEL3));
        model.put("level4Missions", missionRepository.findAllNamesByLevel(Level.LEVEL4));
        model.put("level5Missions", missionRepository.findAllNamesByLevel(Level.LEVEL5));
    }


}
