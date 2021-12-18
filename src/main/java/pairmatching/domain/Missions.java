package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Missions {
	List<Mission> missions;

	public Missions(){
		missions = new ArrayList<>();
		makeLevelOneMission();
		makeLevelTwoMission();
		makeLevelFourMission();
	}

	public void makeLevelOneMission(){
		missions.add(new Mission(Course.BACKEND, Level.LEVEL1, "자동차경주"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL1, "자동차경주"));
		missions.add(new Mission(Course.BACKEND, Level.LEVEL1, "로또"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL1, "로또"));
		missions.add(new Mission(Course.BACKEND, Level.LEVEL1, "숫자야구"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL1, "숫자야구"));
	}

	public void makeLevelTwoMission(){
		missions.add(new Mission(Course.BACKEND, Level.LEVEL2, "장바구니"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL2, "장바구니"));
		missions.add(new Mission(Course.BACKEND, Level.LEVEL2, "결제"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL2, "결제"));
		missions.add(new Mission(Course.BACKEND, Level.LEVEL2, "지하철노선도"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL2, "지하철노선도"));
	}

	public void makeLevelFourMission(){
		missions.add(new Mission(Course.BACKEND, Level.LEVEL4, "성능개선"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL4, "성능개선"));
		missions.add(new Mission(Course.BACKEND, Level.LEVEL4, "배포"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL4, "배포"));
	}

	public List<Mission> getMissions() {
		return missions;
	}
}
