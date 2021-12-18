package pairmatching.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileReaderTest {
    @Test
    void checkBack() {
        FileReader fileReader = new FileReader("backend-crew.md");
        List<String> backends = fileReader.getNameList();
        List<String> tempList = new ArrayList<>();
        tempList.add("대협");
        tempList.add("현준");
        tempList.add("태산");
        tempList.add("대남");
        assertThat(backends.containsAll(tempList));
    }
}