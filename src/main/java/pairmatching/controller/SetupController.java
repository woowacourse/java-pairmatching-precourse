package pairmatching.controller;

import pairmatching.domain.Level;
import pairmatching.repository.MissionRepository;

import java.util.List;
import java.util.Map;

public class SetupController extends AbstractController {
    @Override
    public void doProcess(Map<String, Object> model) {
        saveMission(Level.LEVEL1, List.of("자동차경주", "로또", "숫자야구게임"));
        saveMission(Level.LEVEL2, List.of("장바구니", "결제", "지하철노선도"));
        saveMission(Level.LEVEL4, List.of("성능개선", "배포"));
    }

    private void saveMission(Level level, List<String> missionNames) {
        for (String missionName : missionNames) {
            MissionRepository.save(level, missionName);
        }
    }
}
