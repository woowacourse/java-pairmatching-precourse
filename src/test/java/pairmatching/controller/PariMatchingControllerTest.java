package pairmatching.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PariMatchingControllerTest {

    PariMatchingController controller;

    @BeforeEach
    void setUp() {
        controller = new PariMatchingController();
    }

    @Test
    void result() {
        assertDoesNotThrow(
            () -> {
                controller.matchPair("로또", "백엔드", "레벨1");
                System.out.println(controller.getResult("로또", "백엔드", "레벨1"));
            }
        );
    }
}