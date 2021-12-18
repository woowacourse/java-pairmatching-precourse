package pairmatching.view;

import pairmatching.domain.Mission;

public class OutputView {
	public static void printMatchInfo(Mission mission){
		System.out.println("페어 매칭 결과입니다.");
		System.out.println(mission.toString());
	}
}
