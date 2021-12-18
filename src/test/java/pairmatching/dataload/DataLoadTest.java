package pairmatching.dataload;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import pairmatching.domains.crew.Crew;
import pairmatching.domains.crew.FrontendCrews;

public class DataLoadTest {
	@Test
	void loadCrewTest() {
		//given
		FrontendCrews frontendCrews = new FrontendCrews();

		//when
		frontendCrews.setFrontendCrews();
		List<Crew> frontendCrewsList = frontendCrews.getFrontendCrews();

		Assertions.assertThat(frontendCrewsList.size()).isEqualTo(15);

	}
}
