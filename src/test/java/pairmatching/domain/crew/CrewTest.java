package pairmatching.domain.crew;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pairmatching.domain.course.Course;
import pairmatching.domain.crew.name.CrewNames;

import static org.assertj.core.api.Assertions.assertThat;

public class CrewTest {
    @Test
    void 크루원_이름_초기화() {
        assertThat(CrewNames.BACK_END.isCount(20)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = "대환")
    void 크루원_생성(String name) {
        Crew crew = Crew.of(name, Course.BACKEND);
        assertThat(crew.isName("대환")).isTrue();
    }
}
