package pairmatching;

import java.util.ArrayList;

public class LevelService {
    private ArrayList<String> levelList = new ArrayList();
    private ArrayList<String>[] missionList = new ArrayList[5];
    private static final String CAR_RACE = "자동차경주";
    private static final String LOTTO = "로또";
    private static final String BALL_BASEBALL = "숫자야구게임";
    private static final String SHOPPING_BASKET = "장바구니";
    private static final String PAYMENT = "결제";
    private static final String SUBWAY = "지하철노선도";
    private static final String IMPROVEMENT = "성능개선";
    private static final String DEPLOYMENT = "배포";

    LevelService() {
        init();
    }

    public ArrayList<String> getLevelList() {
        return levelList;
    }

    public ArrayList<String>[] getMissionList() {
        return missionList;
    }

    private void init() {
        for (Level l : Level.values()) {
            levelList.add(l.getName());
        }
        for (int i = 0; i < missionList.length; i++) {
            missionList[i] = new ArrayList<>();
        }
        missionList[0].add(CAR_RACE);
        missionList[0].add(LOTTO);
        missionList[0].add(BALL_BASEBALL);
        missionList[1].add(SHOPPING_BASKET);
        missionList[1].add(PAYMENT);
        missionList[1].add(SUBWAY);
        missionList[3].add(IMPROVEMENT);
        missionList[3].add(DEPLOYMENT);
    }

    public void isExistMission(String level, String mission) throws IllegalArgumentException {
        int index = levelList.indexOf(level);
        if(!missionList[index].contains(mission)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 미션입니다.");
        }
    }
}
