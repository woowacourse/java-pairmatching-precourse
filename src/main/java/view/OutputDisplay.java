package view;

import java.util.List;

public class OutputDisplay {

	private OutputDisplay() {
	}

	public static void showProcessAndLevelAndMission() {
		System.out.println();
		System.out.println("#############################################");
		System.out.println("과정: 백엔드 | 프론트엔드");
		System.out.println("미션:");
		System.out.println("	- 레벨1: 자동차경주 | 로또 | 숫자야구게임");
		System.out.println("	- 레벨2: 장바구니 | 결제 | 지하철노선도");
		System.out.println("	- 레벨3:");
		System.out.println("	- 레벨4: 성능개선 | 배포");
		System.out.println("	- 레벨5:");
		System.out.println("############################################");
	}

	public static void showMatchedPairs(List<String> matchedPairs) {
		System.out.println();
		System.out.println("페어 매칭 결과입니다.");
		for (int index = 0; index < matchedPairs.size(); index += 2) {
			if (matchedPairs.size() - index == 3) {
				System.out.println(
					matchedPairs.get(index) + " : " + matchedPairs.get(index + 1) + " : " + matchedPairs.get(
						index + 2));
				break;
			}
			System.out.println(matchedPairs.get(index) + " : " + matchedPairs.get(index + 1));
		}
		System.out.println();
	}
}
