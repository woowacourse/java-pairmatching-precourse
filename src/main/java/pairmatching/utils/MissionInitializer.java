package pairmatching.utils;

import java.util.ArrayList;
import java.util.List;
import pairmatching.mission.Level;
import pairmatching.mission.Mission;

public class MissionInitializer {

    private static final String LEVEL1_RACING = "자동차경주";
    private static final String LEVEL1_LOTTO = "로또";
    private static final String LEVEL1_BASEBALL = "숫자야구게임";
    private static final String LEVEL2_CART = "장바구니";
    private static final String LEVEL2_PAY = "결재";
    private static final String LEVEL2_SUBWAY = "지하철노선도";
    private static final String LEVEL4_OPT = "성능개선";
    private static final String LEVEL4_DEPLOY = "배포";

    public List<Mission> getAvailableMissions() {
        List<Mission> list = new ArrayList<>();
        list.add(new Mission(Level.LEVEL1, LEVEL1_RACING));
        list.add(new Mission(Level.LEVEL1, LEVEL1_LOTTO));
        list.add(new Mission(Level.LEVEL1, LEVEL1_BASEBALL));
        list.add(new Mission(Level.LEVEL2, LEVEL2_CART));
        list.add(new Mission(Level.LEVEL2, LEVEL2_PAY));
        list.add(new Mission(Level.LEVEL2, LEVEL2_SUBWAY));
        list.add(new Mission(Level.LEVEL4, LEVEL4_DEPLOY));
        list.add(new Mission(Level.LEVEL4,LEVEL4_OPT ));
        return list;
    }
}
