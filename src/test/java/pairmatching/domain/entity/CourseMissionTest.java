package pairmatching.domain.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

public class CourseMissionTest {

    private static Stream<Arguments> 제공_코스미션_비교_데이터() {
        return Stream.of(
                Arguments.of(
                        CourseMission.create(Course.BACKEND, Level.LEVEL1, Mission.RACING_CAR),
                        CourseMission.create(Course.BACKEND, Level.LEVEL1, Mission.RACING_CAR),
                        true
                ),
                Arguments.of(
                        CourseMission.create(Course.BACKEND, Level.LEVEL1, Mission.RACING_CAR),
                        CourseMission.create(Course.BACKEND, Level.LEVEL2, Mission.SHOPPING_CART),
                        false
                ),
                Arguments.of(
                        CourseMission.create(Course.BACKEND, Level.LEVEL1, Mission.RACING_CAR),
                        new Object(),
                        false
                ),
                Arguments.of(
                        CourseMission.create(Course.BACKEND, Level.LEVEL1, Mission.RACING_CAR),
                        null,
                        false
                )
        );
    }

    @ParameterizedTest
    @MethodSource("제공_코스미션_비교_데이터")
    void 코스미션_동등성_테스트(CourseMission mission1, Object mission2, boolean expected) {
        // When: 실행
        boolean result = mission1.equals(mission2);

        // Then: 검증
        assertEquals(expected, result);
    }
}
