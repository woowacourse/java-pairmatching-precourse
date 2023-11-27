package pairmatching.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.domain.entity.MatchingResult;
import pairmatching.repository.MatchingResultRepository;

public class MatchingServiceTest {

    private static Stream<Arguments> 제공_크루목록과_예상_매칭결과() {
        return Stream.of(
                Arguments.of(Arrays.asList("크루1", "크루2"), 1), // 2명의 크루, 1개의 페어 예상
                Arguments.of(Arrays.asList("크루1", "크루2", "크루3"), 1), // 3명의 크루, 1개의 페어 예상 (3인 페어)
                Arguments.of(Arrays.asList("크루1", "크루2", "크루3", "크루4"), 2), // 4명의 크루, 2개의 페어 예상
                Arguments.of(Arrays.asList("크루1", "크루2", "크루3", "크루4", "크루5"), 2), // 5명의 크루, 3개의 페어 예상
                Arguments.of(Arrays.asList(
                        "크루1", "크루2", "크루3", "크루4", "크루5", "크루6"), 3) // 6명의 크루, 3개의 페어 예상
        );
    }

    @ParameterizedTest
    @MethodSource("제공_크루목록과_예상_매칭결과")
    void 매칭결과_생성_테스트(List<String> crews, int expectedNumberOfPairs) {
        MatchingService matchingService = new MatchingService(new MatchingResultRepository());
        // When: 실행
        MatchingResult matchingResult = matchingService.createMatchingResult(crews);

        // Then: 검증
        assertNotNull(matchingResult);
        assertEquals(expectedNumberOfPairs, matchingResult.getPairs().size());
    }
}
