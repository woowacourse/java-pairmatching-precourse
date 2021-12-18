package pairmatching.domain.repository;

import static javax.swing.JOptionPane.*;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class MissionRepository {
	static List<Mission> missionList = new ArrayList<>();

	static {
		missionList.add(new Mission( "자동차 경주"));
		missionList.add(new Mission( "로또"));
		missionList.add(new Mission( "숫자야구게임"));
		missionList.add(new Mission("장바구니"));
		missionList.add(new Mission("결제"));
		missionList.add(new Mission("지하철노선도"));
	}


	public Mission findMission(String level, String name) {
		return missionList.stream()
			.filter(mission -> mission.isSame(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE + "올바르지 않은 미션 입력 값 입니다."));
	}
}
