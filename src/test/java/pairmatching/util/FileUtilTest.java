package pairmatching.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FileUtilTest {

    private static Stream<Arguments> provideLinesForTest() {
        return Stream.of(
                Arguments.of(0, "백호"), Arguments.of(1, "태웅"), Arguments.of(2, "치수"),
                Arguments.of(3, "태섭"), Arguments.of(4, "대만"), Arguments.of(5, "준호"),
                Arguments.of(6, "대협"), Arguments.of(7, "덕규"), Arguments.of(8, "태산"),
                Arguments.of(9, "경태"), Arguments.of(10, "수겸"), Arguments.of(11, "현준"),
                Arguments.of(12, "준섭"), Arguments.of(13, "한나"), Arguments.of(14, "소연"),
                Arguments.of(15, "호열"), Arguments.of(16, "대남"), Arguments.of(17, "용팔"),
                Arguments.of(18, "구식"), Arguments.of(19, "달재")
        );
    }

    @ParameterizedTest
    @MethodSource("provideLinesForTest")
    public void testFileContent(int lineIndex, String expectedLine) throws IOException, URISyntaxException {
        final String filePath
                = Paths.get(getClass().getClassLoader().getResource("backend-crew.md").toURI()).toString();
        final List<String> members = FileUtil.readFileAsList(filePath);
        final String result = members.get(lineIndex);

        assertEquals(expectedLine, result, "Mismatch at line " + (lineIndex + 1));
    }
}
