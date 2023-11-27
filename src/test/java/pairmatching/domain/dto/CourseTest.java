package pairmatching.domain.dto;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import pairmatching.domain.entity.Course;

public class CourseTest {

    private static Stream<Arguments> 코스이름_및_예상코스() {
        return Stream.of(
                Arguments.of("백엔드", Course.BACKEND, 20),
                Arguments.of("프론트엔드", Course.FRONTEND, 15)
        );
    }

    private static Stream<String> provideInvalidCourseNames() {
        return Stream.of("잘못된코스", "존재하지않음", "비어있음");
    }

    @ParameterizedTest
    @MethodSource("코스이름_및_예상코스")
    public void 주어진_코스이름으로_코스찾기_테스트(String courseName, Course expectedCourse) {
        // when
        Course result = Course.findCourse(courseName);

        // then
        assertEquals(expectedCourse, result);
    }

    @ParameterizedTest
    @MethodSource("코스이름_및_예상코스")
    public void 주어진_코스의_크루목록_가져오기_테스트(String courseName, Course course, int size) {
        // when
        List<String> crews = course.getCrews();

        // then
        assertNotNull(crews);
        assertThat(crews.size()).isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("코스이름_및_예상코스")
    void 유효한_코스_찾기_테스트(String courseName, Course expectedCourse) {
        Course actualCourse = Course.findCourse(courseName);
        assertEquals(expectedCourse, actualCourse);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidCourseNames")
    void 잘못된_코스_찾기_예외_테스트(String courseName) {
        assertThatThrownBy(() -> Course.findCourse(courseName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
