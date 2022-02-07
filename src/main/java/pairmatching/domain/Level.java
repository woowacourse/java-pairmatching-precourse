package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Level {
	public final int num;
	public ArrayList<Mission> missions = new ArrayList<>();
	public String[] missionNames;

	public Level(int num, String[] missionNames) {
		this.num = num;
		this.missionNames = missionNames;
		setMissions(missionNames);
	}

	public void setMissions(String[] missions) {
		for (String missionName : missions) {
			this.missions.add(new Mission(missionName));
		}
	}

	public Mission findMission(String name) {
		for (Mission mission : missions) {
			if (mission.missionName.equals(name)) {
				return mission;
			}
		}
		return null;
	}

	public void reset() {
		for (Mission mission : missions) {
			mission.reset();
		}
	}

	public void setFrontendMissions(Pairs frontendPairs) {
		// for (String name : Repository.frontendList) {
		// 	ArrayList<String> parameterPairNames = new ArrayList<>(Arrays.asList(frontendPairs.findPair(name)));
		// 	ArrayList<String> nowPairNames = new ArrayList<>();
		// 	for (int i = 0; i < missions.size(); i++) {
		// 		nowPairNames.addAll(Arrays.asList(missions.get(i).frontendPairs.findPair(name)));
		// 	}
		// 	parameterPairNames.addAll(nowPairNames);
		// 	if (parameterPairNames.stream().distinct().count() != frontendPairs.findPair(name).length) {
		// 		throw new IllegalArgumentException();
		// 	}
		// }
		//	이름마다, 이름의 짝이 현재 프론트페어와 미션들페어중에 있을 때 예외처리
	}

	public boolean isEmpty() {
		return missions.isEmpty();
	}

	@Override
	public boolean equals(Object obj) {
		// 모델값 같은지 확인
		return this == obj || (obj instanceof Level && this.hashCode() == obj.hashCode());
	}

	@Override
	public String toString() {
		// 프린트 원하는 방식으로 구현
		String answer = "-레벨" + num + ": ";
		List<String> list = new ArrayList<>();
		for (Mission mission : missions) {
			list.add(mission.toString());
		}
		return answer + String.join(" | ", list);
	}

	@Override
	public int hashCode() {
		// 같은 객체인지 판별하는 기준
		return Objects.hashCode(this.toString());
	}
}
