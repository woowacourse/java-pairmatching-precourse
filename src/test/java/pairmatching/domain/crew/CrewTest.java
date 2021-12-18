package pairmatching.domain.crew;

import org.junit.jupiter.api.Test;
import pairmatching.domain.crew.name.CrewNames;

import static org.assertj.core.api.Assertions.assertThat;

public class CrewTest {
    @Test
    void 크루원_이름_초기화() {
        assertThat(CrewNames.BACK_END.isCount(20)).isTrue();
    }
}
