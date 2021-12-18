package pairmatching;

import pairmatching.model.Level;

public class InitialSetting {
    public void initialInformation(){
        Level.LEVEL1.addMission("자동차경주");
        Level.LEVEL1.addMission("로또");
        Level.LEVEL1.addMission("숫자야구게임");
        Level.LEVEL2.addMission("장바구니");
        Level.LEVEL2.addMission("결제");
        Level.LEVEL2.addMission("지하철 노선도");
        Level.LEVEL4.addMission("성능개선");
        Level.LEVEL4.addMission("배포");
    }
}
