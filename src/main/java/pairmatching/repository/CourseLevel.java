package pairmatching.repository;

import java.util.Arrays;

public class CourseLevel {
	private String[] level1Mission = {"자동차경주", "로또", "숫자야구게임"};
	private String[] level2Mission = {"장바구니", "결제", "지하철노선도"};
	private String[] level4Mission = {"성능개선", "배포"};

	public boolean isMissionInLevel1(String mission) {
		return Arrays.asList(level1Mission).contains(mission);
	}

	public boolean isMissionInLevel2(String mission) {
		return Arrays.asList(level2Mission).contains(mission);
	}

	public boolean isMissionInLevel4(String mission) {
		return Arrays.asList(level4Mission).contains(mission);
	}
}
