package pairmatching;

import static camp.nextstep.edu.missionutils.test.Assertions.assertShuffleTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import pairmatching.Application;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 짝수_인원_페어_매칭() {
        assertShuffleTest(
            () -> {
                run("1", "백엔드, 레벨1, 자동차경주", "Q");
                assertThat(output()).contains("태웅 : 백호", "치수 : 태섭");
            },
            Arrays.asList("태웅", "백호", "치수", "태섭")
        );
    }

    @Test
    void 홀수_인원_페어_매칭() {
        assertShuffleTest(
                () -> {
                    run("1", "프론트엔드, 레벨1, 자동차경주", "Q");
                    assertThat(output()).contains("보노 : 시저", "쉐리 : 신디 : 다비");
                },
                Arrays.asList("보노", "시저", "쉐리", "신디", "다비")
        );
    }

    @Test
    void 재매칭_실패() {
        assertShuffleTest(
                () -> {
                    runException("1", "백엔드, 레벨1, 자동차경주", "1", "백엔드, 레벨1, 자동차경주", "네", "프론트엔드, 레벨1, 자동차경주");
                    assertThat(output()).contains("3번의 리매칭을 모두 실패했습니다.");
                },
                Arrays.asList("태웅", "백호", "치수", "태섭"),
                Arrays.asList("태웅", "백호", "치수", "태섭"),
                Arrays.asList("태웅", "백호", "치수", "태섭"),
                Arrays.asList("태웅", "백호", "치수", "태섭"),
                Arrays.asList("보노", "시저", "쉐리", "신디", "다비")
        );
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

    @Test
    void 없는_코스에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("1", "안드로이드, 레벨1, 자동차경주");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 없는_레벨에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("1", "백엔드, 레벨6, 자동차경주");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 매칭되지_않는_미션에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("1", "백엔드, 레벨2, 숫자야구게임");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
