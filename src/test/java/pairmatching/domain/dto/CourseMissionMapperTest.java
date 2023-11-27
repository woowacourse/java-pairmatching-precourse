package pairmatching.domain.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.domain.entity.Course;
import pairmatching.domain.entity.CourseMission;
import pairmatching.domain.entity.Level;
import pairmatching.domain.entity.Mission;

public class CourseMissionMapperTest {

    private static Stream<Arguments> provideInputForCourseMission() {
        return Stream.of(
                Arguments.of(
                        "백엔드, 레벨1, 자동차경주",
                        Course.BACKEND,
                        Level.LEVEL1,
                        Mission.RACING_CAR),
                Arguments.of("프론트엔드, 레벨2, 장바구니",
                        Course.FRONTEND,
                        Level.LEVEL2,
                        Mission.SHOPPING_CART)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputForCourseMission")
    public void testToCourseMission(String input,
                                    Course expectedCourse,
                                    Level expectedLevel,
                                    Mission expectedMission) {
        CourseMission courseMission = CourseMissionMapper.toCourseMission(input);

        assertNotNull(courseMission);
        assertEquals(expectedCourse, courseMission.getCourse());
        assertEquals(expectedLevel, courseMission.getLevel());
        assertEquals(expectedMission, courseMission.getMission());
    }
}
