package pairmatching.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissionRepository {
	private static final List<Mission> missionList = new ArrayList<>();

	static {
		missionList.add(new Mission(Level.LEVEL1, "자동차경주"));
		missionList.add(new Mission(Level.LEVEL1, "로또"));
		missionList.add(new Mission(Level.LEVEL1, "숫자야구게임"));
		missionList.add(new Mission(Level.LEVEL2, "장바구니"));
		missionList.add(new Mission(Level.LEVEL2, "결제"));
		missionList.add(new Mission(Level.LEVEL2, "지하철노선도"));
		missionList.add(new Mission(Level.LEVEL4, "성능개선"));
		missionList.add(new Mission(Level.LEVEL4, "배포"));
	}

	public static List<Mission> missionList() {
		return Collections.unmodifiableList(missionList);
	}
}
