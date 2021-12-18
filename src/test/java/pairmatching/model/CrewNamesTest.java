package pairmatching.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CrewNamesTest {
	@Test
	void 파일에서_크루이름_불러오기() {
		assertThat(new BackendCrewNames().get()).contains("백호", "태섭", "대만");
		assertThat(new FrontendCrewNames().get()).contains("보노", "리사", "니콜");
	}

}
