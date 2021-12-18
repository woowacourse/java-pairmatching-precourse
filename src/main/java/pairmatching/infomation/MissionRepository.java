package pairmatching.infomation;

import java.util.ArrayList;

public class MissionRepository {
    private static final ArrayList<Mission> missions = new ArrayList<>();

    static {
        missions.add(new Mission(1, "자동차 경주"));
        missions.add(new Mission(1, "로또"));
        missions.add(new Mission(1, "숫자야구게임"));

        missions.add(new Mission(2, "장바구니"));
        missions.add(new Mission(2, "결제"));
        missions.add(new Mission(2, "지하철노선도"));

        missions.add(new Mission(3, ""));

        missions.add(new Mission(4, "성능개선"));
        missions.add(new Mission(4, "배포"));

        missions.add(new Mission(5, ""));
    }
}
