package pairmatching.model.crew;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrewPairTest {
    @Test
    @DisplayName("")
    void isSameWithOfTwo() {
        String course = "백엔드";
        CrewPair crewPair = new CrewPair(Crew.of("a", course), Crew.of("b", course));
        CrewPair another = new CrewPair(Crew.of("b", course), Crew.of("c", course));
        boolean actual = crewPair.isSameCaseWith(another);
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("")
    void isSameWithOfThree() {
        String course = "백엔드";
        CrewPair crewPair = new CrewPair(Crew.of("a", course), Crew.of("b", course));
        CrewPair another =
                new CrewPair(Crew.of("b", course), Crew.of("a", course), Crew.of("c", course));
        boolean actual = crewPair.isSameCaseWith(another);
        assertThat(actual).isTrue();
    }

}