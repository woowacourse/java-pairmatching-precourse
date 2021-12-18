package pairmatching.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Pair;
import pairmatching.domain.enumeration.Mission;
import pairmatching.domain.enumeration.Pairs;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
        pairRepository.createPairs(Mission.CAR_RACING, pairs);

        assertThat(pairRepository.findByMission(Mission.CAR_RACING)
                .getPairList()
                .size())
                .isEqualTo(1);

    }

}