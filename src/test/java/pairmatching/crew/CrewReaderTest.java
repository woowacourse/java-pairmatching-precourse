package pairmatching.crew;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
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
}