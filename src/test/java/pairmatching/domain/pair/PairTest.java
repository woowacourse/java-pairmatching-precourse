package pairmatching.domain.pair;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pairmatching.domain.course.Course;

import static org.assertj.core.api.Assertions.assertThat;

public class PairTest {
    @ParameterizedTest
    @CsvSource(value = {"대환,포비"}, delimiter = ',')
    void 페어_생성(String crew1, String crew2) {
        Pair pair = Pair.of(crew1, crew2, Course.BACKEND);
        assertThat(pair.hasCrewName("대환")).isTrue();
    }
}
