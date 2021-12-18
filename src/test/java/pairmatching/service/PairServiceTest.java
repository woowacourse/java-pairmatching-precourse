package pairmatching.service;

import org.junit.jupiter.api.Test;
import pairmatching.domain.enumeration.Pairs;
import pairmatching.repository.PairRepository;

class PairServiceTest {

    @Test
    void 페어_매칭_홀수() {
        PairService pairService = new PairService(new PairRepository());
        Pairs pairs = pairService.createPairs(pairService.validateInput("프론트엔드, 레벨1, 자동차경주"));
        System.out.println(pairs);
    }

    @Test
    void 페어_매칭_짝수() {
        PairService pairService = new PairService(new PairRepository());
        Pairs pairs = pairService.createPairs(pairService.validateInput("백엔드, 레벨1, 자동차경주"));
        System.out.println(pairs);
    }

}