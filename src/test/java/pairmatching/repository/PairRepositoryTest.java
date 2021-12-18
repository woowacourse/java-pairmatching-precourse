package pairmatching.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Category;
import pairmatching.domain.Pair;
import pairmatching.domain.enumeration.Course;
import pairmatching.domain.enumeration.Mission;
import pairmatching.domain.Pairs;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class PairRepositoryTest {
    @Test
    void 페어_저장() {
        Pairs pairs = new Pairs();
        pairs.addPair(new Pair(Arrays.asList(CrewRepository.getCrews().get(0))));
        PairRepository.createPairs(new Category(Mission.CAR_RACING, Course.BACKEND), pairs);

        assertThat(PairRepository.findByCategory(new Category(Mission.CAR_RACING, Course.BACKEND))
                .getPairList()
                .size())
                .isEqualTo(1);

    }

}