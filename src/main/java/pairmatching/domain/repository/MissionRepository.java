package pairmatching.domain.repository;




import static pairmatching.utils.Constants.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import pairmatching.domain.Mission;

public class MissionRepository {
	static List<Mission> missionList = new ArrayList<>();

	static {
		missionList.add(new Mission( "자동차경주"));
		missionList.add(new Mission( "로또"));
		missionList.add(new Mission( "숫자야구게임"));
		missionList.add(new Mission("장바구니"));
		missionList.add(new Mission("결제"));
		missionList.add(new Mission("지하철노선도"));
	}


	public static Mission findMission(String name) {
		return missionList.stream()
			.filter(mission -> mission.isSame(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE + "올바르지 않은 미션 입력 값 입니다."));
	}
}
