package pairmatching.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Crew;
import pairmatching.domain.enumeration.Course;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CrewRepositoryTest {

    @Test
    void 최초_크루_저장_확인() {
        List<Crew> crews = CrewRepository.getCrews();
        assertThat(crews.size()).isEqualTo(35);
    }

    @Test
    void 크루_셔플() {
        List<Crew> crews = CrewRepository.getCrews();

        List<Crew> shuffledCrew = CrewRepository.shuffleCrew(Course.BACKEND);

        assertThat(shuffledCrew.size()).isEqualTo(20);
    }


}