package pairmatching.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pairmatching.dto.MissionDto;

class MatchingServiceTest {

    MatchingService service = new MatchingService(new FixedCrewMatcher());
    MissionDto missionDto = MissionDto.from(List.of("백엔드", "레벨1", "로또"));

    @Test
    @DisplayName("매칭에 3번 실패하면 예외가 발생한다.")
    void 매칭_연속_실패_테스트(){
        //given
        service.matching(missionDto);

        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> service.matching(missionDto))
                .withMessage("매칭에 실패했습니다.");

    }
}