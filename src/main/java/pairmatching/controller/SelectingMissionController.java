package pairmatching.controller;

import pairmatching.inputview.InputView;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.outputview.OutputView;
import pairmatching.repository.MissionRepository;
import pairmatching.vo.PairMatchingInfo;

import java.util.Map;

public class SelectingMissionController extends AbstractController {
    private final OutputView outputView;
    private final InputView<PairMatchingInfo> inputView;
    private final MissionRepository missionRepository;

    public SelectingMissionController(OutputView outputView, InputView<PairMatchingInfo> inputView, MissionRepository missionRepository) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.missionRepository = missionRepository;
    }

    @Override
    public void doProcess(Map<String, Object> model) {
        printMessage(model);
        readInputIntoModel(model);
    }

    private void readInputIntoModel(Map<String, Object> model) {
        putAllMissionsToModel(model);
        model.put("pairMatchingInfo", inputView.getInput(model));
    }

    private void printMessage(Map<String, Object> model) {
        putCoursesNameToModel(model);
        putMissionNamesToModel(model);
        outputView.print(model);
    }

    private Object putAllMissionsToModel(Map<String, Object> model) {
        return model.put("missions", missionRepository.findAll());
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
