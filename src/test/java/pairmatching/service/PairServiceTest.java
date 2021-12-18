package pairmatching.service;

import org.junit.jupiter.api.Test;
import pairmatching.domain.Pairs;
import pairmatching.repository.PairRepository;

class PairServiceTest {

    @Test
    void 페어_매칭_홀수() {
        Pairs pairs = PairService.createPairs(PairService.validateInput("프론트엔드, 레벨1, 자동차경주"));
        System.out.println(pairs);
    }

    @Test
    void 페어_매칭_짝수() {
        Pairs pairs = PairService.createPairs(PairService.validateInput("백엔드, 레벨1, 자동차경주"));
        System.out.println(pairs);
    }

}