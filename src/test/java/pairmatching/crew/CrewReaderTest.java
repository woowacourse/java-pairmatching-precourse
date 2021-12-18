package pairmatching.crew;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.utils.CrewListInitializer;
import pairmatching.utils.CrewReader;

class CrewReaderTest {


    @Test
    void readTest() {
        assertDoesNotThrow(
            CrewReader::readBackendCrews
        );
    }

    @Test
    void readFront() {
        assertDoesNotThrow(
            CrewReader::readFrontEndCrews
        );
    }

    @Test
    void parseBack() {
        assertDoesNotThrow(
            () -> {
                List<Crew> crews = CrewListInitializer.getBackendCrews();
                assert crews.stream().allMatch(c -> c.getPosition() == Position.BACKEND);
            }
        );
    }

    @Test
    void parseFront() {
        assertDoesNotThrow(
            () -> {
                List<Crew> crews = CrewListInitializer.getFrontEndCrews();
                assert crews.stream().allMatch(c -> c.getPosition() == Position.FRONTEND);
            }
        );
    }
}