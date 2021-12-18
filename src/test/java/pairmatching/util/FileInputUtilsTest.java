package pairmatching.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class FileInputUtilsTest {

	@Test
	void 백엔드_크루_명단() {
		List<String> crewsNames = FileInputUtils.getBackendCrewsNames();
		assertThat(crewsNames).contains("백호", "태웅", "치수", "태섭", "대만", "준호", "대협", "덕규",
			"태산", "경태", "수겸", "현준", "준섭", "한나", "소연", "호열", "대남", "용팔", "구식", "달재");
		assertThat(crewsNames.size()).isEqualTo(20);
	}

	@Test
	void 프론트엔드_크루_명단() {
		List<String> crewsNames = FileInputUtils.getFrontendCrewsNames();
		assertThat(crewsNames).contains(  "보노", "시저", "쉐리", "신디", "다비", "덴버", "이브", "제시", "라라",
			"린다", "리사", "니콜", "로드", "윌터", "제키");
		assertThat(crewsNames.size()).isEqualTo(15);
	}
}