package pairmatching;

import java.util.Arrays;
import pairmatching.domain.LevelMisson;
import pairmatching.domain.LevelMissonRepository;
import pairmatching.enums.Level;

public class Setup {
    public void setupMissons() {
        LevelMissonRepository.addMission(new LevelMisson(Level.LEVEL1, Arrays.asList(
            new String[]{"자동차경주", "로또", "숫자야구게임"})));
        LevelMissonRepository.addMission(new LevelMisson(Level.LEVEL1, Arrays.asList(
            new String[]{"장바구니", "결제", "지하철노선도"})));
        LevelMissonRepository.addMission(new LevelMisson(Level.LEVEL1, Arrays.asList(
            new String[]{})));
        LevelMissonRepository.addMission(new LevelMisson(Level.LEVEL1, Arrays.asList(
            new String[]{"성능개선", "배포"})));
        LevelMissonRepository.addMission(new LevelMisson(Level.LEVEL1, Arrays.asList(
            new String[]{})));
    }
}
