package pairmatching.View;

import static camp.nextstep.edu.missionutils.Console.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Input {

	private final static String BACKEND_PATH = "src/main/resources/backend-crew.md";
	private final static String FRONTEND_PATH = "src/main/resources/frontend-crew.md";
	private final static String ERROR_NO_BACKMEMBER = "[ERROR] 백엔드 맴버 파일 없음";
	private final static String ERROR_NO_FRONTMEMBER = "[ERROR] 프론트엔드 맴버 파일 없음";

	public String inputFeat() {
		// 1 2 3 q인지 검증
		return readLine();
	}

	public String inputCourseLevelMission() {
		//검증하기
		// 존재하는지 ,3개 맞는지
		return readLine();
	}

	public String inputYesNO() {
		// 네 아니오 인지 검증
		return readLine();
	}

	public static List<String> getBackMember() {
		List<String> backMemberList = null;
		try {
			backMemberList = Files.readAllLines(Paths.get(BACKEND_PATH));
		} catch (IOException e) {
			System.out.println(ERROR_NO_BACKMEMBER);
		}
		return backMemberList;
	}

	public static List<String> getFrontMember() {
		List<String> frontMemberList = null;
		try {
			frontMemberList = Files.readAllLines(Paths.get(FRONTEND_PATH));
		} catch (IOException e) {
			System.out.println(ERROR_NO_FRONTMEMBER);
		}
		return frontMemberList;
	}
}
