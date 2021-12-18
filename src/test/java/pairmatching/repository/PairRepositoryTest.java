package pairmatching.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Category;
import pairmatching.domain.Pair;
import pairmatching.domain.enumeration.Course;
import pairmatching.domain.enumeration.Mission;
import pairmatching.domain.enumeration.Pairs;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class PairRepositoryTest {

    PairRepository pairRepository;

    @BeforeEach
    void setUp() {
        pairRepository = new PairRepository();
    }

    @Test
    void 페어_저장() {
        Pairs pairs = new Pairs();
        pairs.addPair(new Pair(Arrays.asList(CrewRepository.getCrews().get(0))));
        pairRepository.createPairs(new Category(Mission.CAR_RACING, Course.BACKEND), pairs);

        assertThat(pairRepository.findByCategory(new Category(Mission.CAR_RACING, Course.BACKEND))
                .getPairList()
                .size())
                .isEqualTo(1);

    }

}