package pairmatching.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MyFileReaderTest {

    @Test
    void 백엔드_크루_파일_읽어오기() {
        List<String> backendCrews = MyFileReader.readBackendCrewFile();
        assertThat(backendCrews.size()).isEqualTo(20);
        assertThat(backendCrews).contains(
                "백호",
                "태웅",
                "치수"
        );
    }

    @Test
    void 프론트엔드_크루_파일_읽어오기() {
        List<String> frontendCrews = MyFileReader.readFrontendCrewFile();
        assertThat(frontendCrews.size()).isEqualTo(15);
        assertThat(frontendCrews).contains(
                "보노",
                "시저",
                "쉐리"
        );
    }

}