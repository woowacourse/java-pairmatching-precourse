package pairmatching.util.pairProvider;

import org.junit.jupiter.api.Test;
import pairmatching.domain.course.Course;
import pairmatching.domain.pair.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PairProviderTest {
    private List<String> tmpNameList = Arrays.asList("대환","포비");

    @Test
    void Pair_랜덤_생성() {
        Set<Pair> pairSet = PairProvider.getPairsRandomly(tmpNameList, Course.BACKEND);
        assertThat(pairSet.size()).isEqualTo(1);
    }

}
