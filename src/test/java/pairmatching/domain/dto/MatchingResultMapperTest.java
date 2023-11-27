package pairmatching.domain.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.domain.entity.MatchingResult;
import pairmatching.domain.entity.Pair;

public class MatchingResultMapperTest {
    private static Stream<Arguments> 제공_매칭결과와_예상결과() {
        return Stream.of(
                Arguments.of(
                        MatchingResult.create(Arrays.asList(Pair.create(Arrays.asList("크루1", "크루2")))),
                        Arrays.asList(Arrays.asList("크루1", "크루2"))
                )
        );
    }


    @ParameterizedTest
    @MethodSource("제공_매칭결과와_예상결과")
    void 매칭결과_DTO_변환_테스트(MatchingResult matchingResult, List<List<String>> expected) {
        // When: 실행
        List<List<String>> actual = MatchingResultMapper.from(matchingResult).getMatchingResult();

        // Then: 검증
        assertEquals(expected, actual);
    }
}
