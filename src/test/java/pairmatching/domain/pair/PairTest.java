package pairmatching.domain.pair;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PairTest {
	@Test
	void 이미_페어() {
		// given
		List<String> crewNames = new ArrayList<>();
		crewNames.add("crew1");
		crewNames.add("crew2");

		// when
		Pair pair1 = new Pair(crewNames);
		Pair pair2 = new Pair(crewNames);

		// then
		Assertions.assertThat(pair1.alreadyPair(pair2)).isEqualTo(true);
	}
}