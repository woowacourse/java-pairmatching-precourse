package pairmatching.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.repository.PairRepository;

import java.util.List;

class PairServiceTest {

    @Test
    void 페어_매칭_홀수() {
        Pairs pairs = PairService.createPairs(PairService.validateInput("프론트엔드, 레벨1, 로또"));
        List<Pair> pairList = pairs.getPairList();
        Assertions.assertThat(pairList.get(pairList.size() - 1).getCrews().size()).isEqualTo(3);
        System.out.println(pairs);
    }

    @Test
    void 페어_매칭_짝수() {
        Pairs pairs = PairService.createPairs(PairService.validateInput("백엔드, 레벨1, 로또"));
        List<Pair> pairList = pairs.getPairList();
        Assertions.assertThat(pairList.get(pairList.size() - 1).getCrews().size()).isEqualTo(2);
        System.out.println(pairs);
    }

}