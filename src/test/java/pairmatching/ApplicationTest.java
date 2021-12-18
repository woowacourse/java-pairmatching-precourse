package pairmatching;

import static camp.nextstep.edu.missionutils.test.Assertions.assertShuffleTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import pairmatching.Application;
import pairmatching.domain.Crew;
import pairmatching.domain.enumeration.Course;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 짝수_인원_페어_매칭() {
        List<Crew> crews = new ArrayList<>();
        addCrews(crews);
        assertShuffleTest(
            () -> {
                run("1", "백엔드, 레벨1, 자동차경주", "Q");
                assertThat(output()).contains("태웅 : 백호", "치수 : 태섭");
            },
            crews
        );
    }

    private void addCrews(List<Crew> crews) {
        crews.add(new Crew(Course.BACKEND,"태웅"));
        crews.add(new Crew(Course.BACKEND,"백호"));
        crews.add(new Crew(Course.BACKEND,"치수"));
        crews.add(new Crew(Course.BACKEND,"태섭"));
    }

    @Test
    void 없는_미션에_대한_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("1", "백엔드, 레벨1, 오징어게임");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
