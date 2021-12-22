package pairmatching;

public class SelectSkill {

	static String[] skillList = { "1", "2", "3", "Q","q" };
	static String errorMessage;
	// 기능선택 체크
	public static int checkSkill() {
		String select ;
		while (true) {
			try {
				select =Input.skillSelect();
				select = select.trim();
				vaild(select);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(errorMessage);
			}
		}
		if (select.equals(skillList[0])) {
			
			//페어 매칭
			Matching.matchingHashMap();
			return 1;
		}
		if (select.equals(skillList[1])) {
			// 페어 조회
			Matching.searchingStart();
			return 1;
		}
		if (select.equals(skillList[2])) {
			// 페어 초기화
			Matching.cleanPair();
			return 1;
		}
		
		return 0;

	}

	// 유효성 검사
	public static boolean vaild(String select) {
		for (String s : skillList) {
			if (s.equals(select)) {
				return true;
			}
		}
		errorMessage = "[ERROR]잘못된 기능선택입니다.";
		throw new IllegalArgumentException("[ERROR]잘못된 기능선택입니다.");
	}

}
