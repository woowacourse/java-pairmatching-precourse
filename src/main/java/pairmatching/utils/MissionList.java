package pairmatching.utils;

import java.util.ArrayList;
import java.util.List;

import pairmatching.models.Level;
import pairmatching.models.Mission;

public class MissionList {

	private static final String LEVEL_1_RACING_GAME = "자동차경주";
	private static final String LEVEL_1_LOTTO = "로또";
	private static final String LEVEL_1_NUMBER_BASEBALL = "숫자야구 게임";
	private static final String LEVEL_2_CART = "장바구니";
	private static final String LEVEL_2_PAYMENT = "결제";
	private static final String LEVEL_2_SUBWAY_PATH = "지하철노선도";
	private static final String LEVEL_4_IMPROVE_PERFORMANCE = "성능개선";
	private static final String LEVEL_4_PRODUCT = "배포";

	private Mission makeLevel1() {
		final Mission level1 = new Mission(Level.LEVEL1.getLevel(), new ArrayList<>());
		level1.addMission(LEVEL_1_RACING_GAME);
		level1.addMission(LEVEL_1_LOTTO);
		level1.addMission(LEVEL_1_NUMBER_BASEBALL);
		return level1;
	}

	private Mission makeLevel2() {
		final Mission level2 = new Mission(Level.LEVEL2.getLevel(), new ArrayList<>());
		level2.addMission(LEVEL_2_CART);
		level2.addMission(LEVEL_2_PAYMENT);
		level2.addMission(LEVEL_2_SUBWAY_PATH);
		return level2;
	}

	private Mission makeLevel4() {
		final Mission level4 = new Mission(Level.LEVEL4.getLevel(), new ArrayList<>());
		level4.addMission(LEVEL_4_IMPROVE_PERFORMANCE);
		level4.addMission(LEVEL_4_PRODUCT);
		return level4;
	}

	private Mission makeLevel3() {
		return new Mission(Level.LEVEL3.getLevel(), new ArrayList<>());
	}

	private Mission makeLevel5() {
		return new Mission(Level.LEVEL5.getLevel(), new ArrayList<>());
	}

	public List<Mission> initMissionList() {
		final Mission level1 = makeLevel1();
		final Mission level2 = makeLevel2();
		final Mission level3 = makeLevel3();
		final Mission level4 = makeLevel4();
		final Mission level5 = makeLevel5();
		final List<Mission> missions = new ArrayList<>();
		missions.add(level1);
		missions.add(level2);
		missions.add(level3);
		missions.add(level4);
		missions.add(level5);
		return missions;
	}

}
