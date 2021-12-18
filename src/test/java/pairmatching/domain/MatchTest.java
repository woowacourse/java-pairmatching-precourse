package pairmatching.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MatchTest {

    @Nested
    @DisplayName("Match가 동일한지 확인할 수 있다.")
    class IsSameMatchTest {

        private Crew firstCrew;
        private Crew secondCrew;
        private Crew thirdCrew;

        @BeforeEach
        void beforeEach() {
            firstCrew = new Crew(Course.BACKEND, "firstCrew");
            secondCrew = new Crew(Course.BACKEND, "secondCrew");
            thirdCrew = new Crew(Course.BACKEND, "thirdCrew");
        }

        @Test
        @DisplayName("일치")
        void trueTest() {
            // given
            Match firstMatch = new Match(firstCrew, secondCrew);
            Match secondMatch = new Match(secondCrew, firstCrew);

            // when
            boolean result = firstMatch.isSameMatch(secondMatch);

            // then
            assertTrue(result);
        }

        @Test
        @DisplayName("불일치")
        void falseTest() {
            // given
            Match firstMatch = new Match(firstCrew, secondCrew);
            Match secondMatch = new Match(secondCrew, thirdCrew);

            // when
            boolean result = firstMatch.isSameMatch(secondMatch);

            // then
            assertFalse(result);
        }
    }
}