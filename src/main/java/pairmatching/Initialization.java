package pairmatching;

import domain.BackendRepository;
import domain.FrontendRepository;
import domain.Level;

public class Initialization {
    public static void intialize() {
        BackendRepository backendRepository = new BackendRepository();
        FrontendRepository frontendRepository = new FrontendRepository();
        backendRepository.addCrewNames();
        frontendRepository.addCrewNames();
    
        Level.LEVEL1.addMissions("자동차경주");
        Level.LEVEL1.addMissions("로또");
        Level.LEVEL1.addMissions("숫자야구게임");
        Level.LEVEL2.addMissions("장바구니");
        Level.LEVEL2.addMissions("결제");
        Level.LEVEL2.addMissions("지하철노선도");
        Level.LEVEL4.addMissions("성능개선");
        Level.LEVEL4.addMissions("배포");
    }
}
