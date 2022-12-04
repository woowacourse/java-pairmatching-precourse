package controller;

import model.Level;
import repository.MissionRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SavingMissionsController implements Controller {
    private final MissionRepository missionRepository;

    public SavingMissionsController(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    public void process(Map<String, Object> model) {
        saveMissions(getLevelOneMissionNames(), Level.LEVEL1);
        saveMissions(getLevelTwoMissionNames(), Level.LEVEL2);
        saveMissions(getLevelFiveMissionNames(), Level.LEVEL4);
    }

    private static List<String> getLevelFiveMissionNames() {
        return Arrays.asList("성능개선", "배포");
    }

    private static List<String> getLevelTwoMissionNames() {
        return Arrays.asList("장바구니", "결제", "지하철노선도");
    }

    private static List<String> getLevelOneMissionNames() {
        return Arrays.asList("자동차경주", "로또", "숫자야구게임");
    }

    private void saveMissions(List<String> missionNames, Level level) {
        missionRepository.saveAllNamesWithLevel(missionNames, level);
    }
}
