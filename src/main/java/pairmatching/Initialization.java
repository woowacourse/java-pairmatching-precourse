package pairmatching;

import domain.BackendRepository;
import domain.FrontendRepository;
import domain.Level;
import domain.Mission;

public class Initialization {
    public static void intialize() {
        BackendRepository.addCrewNames();
        FrontendRepository.addCrewNames();
    
        Level.LEVEL1.addMissions(new Mission("자동차게임"));
        Level.LEVEL1.addMissions(new Mission("로또"));
        Level.LEVEL1.addMissions(new Mission("숫자야구게임"));
        Level.LEVEL2.addMissions(new Mission("장바구니"));
        Level.LEVEL2.addMissions(new Mission("결제"));
        Level.LEVEL2.addMissions(new Mission("지하철노선도"));
        Level.LEVEL4.addMissions(new Mission("성능개선"));
        Level.LEVEL4.addMissions(new Mission("배포"));
    }
}
